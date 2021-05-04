package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.controller.StringResponse;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticRepresentationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.ClassifierClient;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentAnalysisModel;
import es.ua.dlsi.grfia.im3ws.muret.model.actionlogs.ActionLogsDocumentAnalysis;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
// !!! Important: no controller should throw any exception

/**
 * @author drizo
 */
@RequestMapping("documentanalysis")
@RestController
public class DocumentAnalysisController extends MuRETBaseController {

    private final RegionTypeRepository regionTypeRepository;
    private final ImageRepository imageRepository;
    private final RegionRepository regionRepository;

    private final AgnosticRepresentationModel agnosticModel;

    private final DocumentAnalysisModel documentAnalysisModel;

    private final ClassifierClient m_client;

    ActionLogsDocumentAnalysis actionLogsDocumentAnalysis;

    @Autowired
    public DocumentAnalysisController(MURETConfiguration muretConfiguration, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository, RegionTypeRepository regionTypeRepository, DocumentAnalysisModel documentAnalysisModel, AgnosticRepresentationModel agnosticModel,
                                      RegionRepository regionrepository, ActionLogsDocumentAnalysis actionLogsDocumentAnalysis) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
        this.regionTypeRepository = regionTypeRepository;
        this.documentAnalysisModel = documentAnalysisModel;
        this.imageRepository = imageRepository;
        this.agnosticModel = agnosticModel;
        this.regionRepository = regionrepository;
        this.m_client = new ClassifierClient(muretConfiguration.getPythonclassifiers());
        this.actionLogsDocumentAnalysis = actionLogsDocumentAnalysis;
    }

    protected RegionType getRegionType(int regionTypeID) throws IM3WSException {
        Optional<RegionType> regionType = regionTypeRepository.findById(regionTypeID);
        if (!regionType.isPresent()) {
            throw new IM3WSException("Cannot find a region type with id " + regionTypeID);
        }
        return regionType.get();
    }



    @PutMapping(path = {"changeRegionsType/{regionTypeID}"})
    @Transactional
    public ChangedRegionTypes changeRegionsType(@PathVariable("regionTypeID") int regionTypeID, @RequestBody LongArray regionIDs)  {
        try {
            ArrayList<Region> changedRegions = new ArrayList<>();
            ArrayList<Long> changedRegionsID = new ArrayList<>();
            for (long regionID: regionIDs.getValues()) {
                Region region = getRegion(regionID);
                RegionType regionType = getRegionType(regionTypeID);

                if (!regionType.equals(region.getRegionType())) {
                    region.setRegionType(regionType);
                    actionLogsDocumentAnalysis.logChangeRegionType(region);
                    changedRegions.add(region);
                    changedRegionsID.add(region.getId());
                }
            }
            regionRepository.saveAll(changedRegions);
            ChangedRegionTypes result = new ChangedRegionTypes();
            result.setRegionTypeID(regionTypeID);
            result.setRegionIDs(new LongArray(changedRegionsID));
            return result;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot update region", e);

        }
    }

    @PutMapping(path = {"regionBoundingBoxUpdate"})
    @Transactional
    public Region regionUpdate(@RequestBody Region region)  {
        try {
            Region persistentRegion = getRegion(region.getId());

            if (region.getBoundingBox() != null) {
                persistentRegion.setBoundingBox(region.getBoundingBox());
            }
            regionRepository.save(persistentRegion);
            actionLogsDocumentAnalysis.logResizeRegion(persistentRegion);
            return persistentRegion;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot update region", e);

        }
    }

    @PutMapping(path = {"pageBoundingBoxUpdate"})
    @Transactional
    public Page pageBoundingBoxUpdate(@RequestBody BoundingBox boundingBox)  {
        try {
            Page page = getPage(boundingBox.getId());
            page.setBoundingBox(boundingBox);
            pageRepository.save(page);
            actionLogsDocumentAnalysis.logResizePage(page);
            return page;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot update page bounding boc", e);
        }
    }

    @Transactional // keep session open - avoid "failed to lazily initialize a collection" error
    @DeleteMapping(path = {"clear/{imageID}"})
    public void clear(@PathVariable("imageID") long imageID) {
        try {
            Image persistentImage = getImage(imageID);
            this.documentAnalysisModel.clear(persistentImage);
            actionLogsDocumentAnalysis.logClear(persistentImage);
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot clear document analysis", e);

        }
    }

    /**
     * Returns the whole list of pages because some regions may have changed from page
     * @param pageCreation
     * @return
     * @throws IM3WSException
     */
    @PostMapping(path = {"createPage"})
    @Transactional
    public Set<Page> createPage(@RequestBody PageCreation pageCreation)  {
        try {
            Image image = getImage(pageCreation.getImageID());
            Set<Page> createdPages = this.documentAnalysisModel.createPage(image, pageCreation.getBoundingBox());
            actionLogsDocumentAnalysis.logCreatePage(image);
            return createdPages;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot create page", e);
        }
    }

    /**
     * @param pageCreation
     * @return
     * @throws IM3WSException
     */
    @PostMapping(path = {"createPages"})
    @Transactional
    public List<Page> createPages(@RequestBody PagesCreation pageCreation)  {
        try {
            Image image = getImage(pageCreation.getImageID());
            List<Page> createdPages = this.documentAnalysisModel.createPages(image, pageCreation.getNumPages());
            actionLogsDocumentAnalysis.logCreatePage(image);
            return createdPages;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot create pages", e);
        }
    }


    /**
     * Returns the whole list of pages because we don't known a priori where the region is to be created
     * @param regionCreation
     * @return
     * @throws IM3WSException
     */
    @PostMapping(path = {"createRegion"})
    @Transactional
    public Set<Page> createRegion(@RequestBody RegionCreation regionCreation)  {
        try {
            Image image = getImage(regionCreation.getImageID());
            Set<Page> pages = this.documentAnalysisModel.createRegion(image, regionCreation.getRegionTypeID(), regionCreation.getBoundingBox());
            actionLogsDocumentAnalysis.logCreateRegion(image);
            return pages;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot create region", e);
        }
    }

    /**
     * Use post instead of delete for sending the request body
     * @param pageIDs
     * @return
     */
    @PostMapping(path = {"deletePages"})
    @Transactional
    public LongArray deletePages(@RequestBody LongArray pageIDs)  {
        try {
            ArrayList<Page> pages = new ArrayList<>();
            LongArray result = new LongArray();
            for (long id: pageIDs.getValues()) {
                Optional<Page> page = pageRepository.findById(id);
                if (page.isPresent()) {
                    if (page.get().getRegions() != null && !page.get().getRegions().isEmpty()) {
                        throw new IM3WSException("A page has regions inside, it cannot be deleted");
                    }
                    pages.add(page.get());
                    result.add(id);
                }
                actionLogsDocumentAnalysis.logDeletePage(page.get());
            }

            pageRepository.deleteAll(pages);
            return result;
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot delete page", e);
        }
    }

    /**
     * Use post instead of delete for sending the request body
     * @param regionIDs
     * @return
     */
    @PostMapping(path = {"deleteRegions"})
    @Transactional
    public LongArray deleteRegions(@RequestBody LongArray regionIDs)  {
        try {
            LongArray result = new LongArray();
            for (long id: regionIDs.getValues()) {
                Optional<Region> region = regionRepository.findById(id);
                if (region.isPresent()) {
                    if (region.get().getSymbols() != null && !region.get().getSymbols().isEmpty()) {
                        throw new IM3WSException("A region has " + region.get().getSymbols().size() + " symbols inside, it cannot be deleted");
                    }
                    documentAnalysisModel.deleteRegion(id);
                    actionLogsDocumentAnalysis.logDeleteRegion(region.get());
                    result.add(id);
                }
            }

            return result;
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot delete page", e);
        }
    }


    @Transactional
    @PostMapping(path = "docAnalyze")
    public List<Page> analyzeDocument(@RequestBody DocAnalysisForm request)
    {
        try {
            Image persistentImage = getImage(request.getImageID());
            Path imagePath = Paths.get(muretConfiguration.getFolder(), persistentImage.computeDocument().getPath(),
                    MURETConfiguration.MASTER_IMAGES, persistentImage.getFilename());
            AutoDocumentAnalysisModel autoDocumentAnalysisModel = m_client.getDocumentAnalysis(request.getImageID(), imagePath, request.getModelToUse());
            actionLogsDocumentAnalysis.logAutomatic(persistentImage, request.getModelToUse());
            return documentAnalysisModel.createAutomaticDocumentAnalysis(persistentImage, request.getNumPages(), autoDocumentAnalysisModel);
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot analyze document", e);
        }
    }

    @PutMapping(value = "rotateImage/{imageID}/{degrees}")
    @Transactional
    public RotatedImage rotateImage(@PathVariable("imageID") Long imageID, @PathVariable("degrees") float degrees) {
        try {
            Image image = getImage(imageID);
            if (degrees < 0) {
                degrees = 360 + degrees;
            }
            image.setRotation(degrees); // don't allow negative values
            imageRepository.save(image);
            return new RotatedImage(imageID, degrees);

            /*File imageFile = getImageFile(null, image, MURETConfiguration.MASTER_IMAGES);

            // extension
            String extension;
            if (imageFile.getName().endsWith("tif") || imageFile.getName().endsWith("tiff")) {
                extension = "TIFF";
            } else if (imageFile.getName().endsWith("jpg")) {
                extension = "JPG";
            } else if (imageFile.getName().endsWith("png")) {
                extension = "PNG";
            } else {
                throw new IM3WSException("Unsupported image extension: " + image.getFilename());
            }
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            File backup = new File(imageFile.getAbsolutePath() + "_backup");
            if (!backup.exists()) {
                // just save the first rotation
                ImageIO.write(bufferedImage, extension, backup);
            }
            BufferedImage rotatedImage = ImageUtils.getInstance().rotate(bufferedImage, degrees);
            ImageIO.write(rotatedImage, extension, imageFile);

            // now notify the image has changed to the server
            notifyServerImageChanged(image);*/
        } catch (Throwable t) {
            throw ControllerUtils.createServerError(this, "Cannot rotate image", t);
        }
    }

    /*private void notifyServerImageChanged(Image image) {
        Path imagePath = Paths.get(muretConfiguration.getFolder(), image.computeDocument().getPath(),
                MURETConfiguration.MASTER_IMAGES, image.getFilename());

        classifierClient.uploadImage(image.getId(), imagePath);
    }*/

    @PutMapping(value = "revertRotation/{imageID}")
    @org.springframework.transaction.annotation.Transactional
    public void revertRotation(@PathVariable("imageID") Long imageID) {
        try {
            Image image = getImage(imageID);
            image.setRotation(0.0F);
            imageRepository.save(image);
            /*File imageFile = getImageFile(null, image, MURETConfiguration.MASTER_IMAGES);

            File backup = new File(imageFile.getAbsolutePath() + "_backup");
            if (backup.exists()) {
                // just save the first rotation
                BufferedImage bufferedImage = ImageIO.read(backup);
                ImageIO.write(bufferedImage, "JPG", imageFile);
            }
            // now notify the image has changed to the server
            notifyServerImageChanged(image);*/

        } catch (Throwable t) {
            throw ControllerUtils.createServerError(this, "Cannot rotate image", t);
        }
    }

        // revisado hasta aquí







    @Transactional
    @DeleteMapping(path={"clearImage/{imageID}"})
    public StringResponse clearAllImageSymbols(@PathVariable(name = "imageID") long imageID)
    {
        //First, we have to get the image pages, because the pages have the regions
        try {
            Optional<Image> imageAttempt = imageRepository.findById(imageID);
            if (imageAttempt.isPresent()) {
                Image imageToHandle = imageAttempt.get(); //Get the image
                Set<Page> pagestoClean = imageToHandle.getPages(); //Get all the pages as we have to clean them one by one
                for (Page page : pagestoClean) {
                    for (Region region : page.getRegions()) {
                        //Erase agnostic symbols
                        agnosticModel.clearRegionSymbols(region.getId());
                        //Erase semantic symbols
                        region.setSemanticEncoding(null);
                        regionRepository.save(region);
                    }
                }
            }
            else throw new IM3WSException("The image does not exist");

            return new StringResponse("Image wiped out");
        }
        catch (IM3WSException exception)
        {
            throw ControllerUtils.createServerError(this, "Cannot clean the image encodings", exception);
        }
    }

    /**
     * It returns the new list of pages of the image
     * @param id
     * @param x
     * @return
     * @throws IM3WSException
     */
    /*@GetMapping(path = {"pageSplit/{id}/{x}"})
    public List<Page> pageSplit(@PathVariable("id") Long id, @PathVariable("x") Double x) throws IM3WSException {
        Optional<Image> image = imageRepository.findById(id);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + id);
        }
        return documentAnalysisModel.pageSplit(image.get(), x.intValue());
    }*/

    /**
     * It returns the new list of pages of the image
     * @param id
     * @param x
     * @return
     * @throws IM3WSException
     */
   /* @GetMapping(path = {"regionSplit/{id}/{x}/{y}"})
    public List<Page> regionSplit(@PathVariable("id") Long id, @PathVariable("x") Double x, @PathVariable("y") Double y) throws IM3WSException {
        Optional<Image> image = imageRepository.findById(id);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + id);
        }
        return documentAnalysisModel.regionSplit(image.get(), x.intValue(), y.intValue());
    }


    @GetMapping(path = {"documentAnalysisClear/{id}"})
    public List<Page>  documentAnalysisClear(@PathVariable("id") Long id) throws IM3WSException {
        Optional<Image> image = imageRepository.findById(id);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + id);
        }
        return documentAnalysisModel.leaveJustOnePageAndRegion(image.get());
    }*/


}
