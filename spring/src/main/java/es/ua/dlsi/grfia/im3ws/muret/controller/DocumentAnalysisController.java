package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.controller.StringResponse;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticRepresentationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.ClassifierClient;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentAnalysisModel;
import es.ua.dlsi.grfia.im3ws.muret.model.SemanticRepresentationModel;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @Autowired
    public DocumentAnalysisController(MURETConfiguration muretConfiguration, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository, RegionTypeRepository regionTypeRepository, DocumentAnalysisModel documentAnalysisModel, AgnosticRepresentationModel agnosticModel,
                                      RegionRepository regionrepository) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
        this.regionTypeRepository = regionTypeRepository;
        this.documentAnalysisModel = documentAnalysisModel;
        this.imageRepository = imageRepository;
        this.agnosticModel = agnosticModel;
        this.regionRepository = regionrepository;
        this.m_client = new ClassifierClient(muretConfiguration.getPythonclassifiers());
    }

    protected RegionType getRegionType(int regionTypeID) throws IM3WSException {
        Optional<RegionType> regionType = regionTypeRepository.findById(regionTypeID);
        if (!regionType.isPresent()) {
            throw new IM3WSException("Cannot find a region type with id " + regionTypeID);
        }
        return regionType.get();
    }



    @PutMapping(path = {"changeRegionsType/{regionTypeID}"})
    public ChangedRegionTypes changeRegionsType(@PathVariable("regionTypeID") int regionTypeID, @RequestBody LongArray regionIDs)  {
        try {
            ArrayList<Region> changedRegions = new ArrayList<>();
            ArrayList<Long> changedRegionsID = new ArrayList<>();
            for (long regionID: regionIDs.getValues()) {
                Region region = getRegion(regionID);
                RegionType regionType = getRegionType(regionTypeID);

                if (!regionType.equals(region.getRegionType())) {
                    region.setRegionType(regionType);
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
    public Region regionUpdate(@RequestBody Region region)  {
        try {
            Region persistentRegion = getRegion(region.getId());

            if (region.getBoundingBox() != null) {
                persistentRegion.setBoundingBox(region.getBoundingBox());
            }
            regionRepository.save(persistentRegion);
            return persistentRegion;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot update region", e);

        }
    }

    @PutMapping(path = {"pageBoundingBoxUpdate"})
    public Page pageBoundingBoxUpdate(@RequestBody BoundingBox boundingBox)  {
        try {
            Page page = getPage(boundingBox.getId());
            page.setBoundingBox(boundingBox);
            pageRepository.save(page);
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
    public Set<Page> createPage(@RequestBody PageCreation pageCreation)  {
        try {
            Set<Page> createdPages = this.documentAnalysisModel.createPage(pageCreation.getImageID(), pageCreation.getBoundingBox());
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
            List<Page> createdPages = this.documentAnalysisModel.createPages(pageCreation.getImageID(), pageCreation.getNumPages());
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
    public Set<Page> createRegion(@RequestBody RegionCreation regionCreation)  {
        try {
            Set<Page> pages = this.documentAnalysisModel.createRegion(regionCreation.getImageID(), regionCreation.getRegionTypeID(), regionCreation.getBoundingBox());
            return pages;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot create region", e);
        }
    }

    @DeleteMapping(path = {"deletePages"})
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
            }

            pageRepository.deleteAll(pages);
            return result;
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot delete page", e);
        }
    }

    @DeleteMapping(path = {"deleteRegions"})
    public LongArray deleteRegions(@RequestBody LongArray regionIDs)  {
        try {
            ArrayList<Region> regions = new ArrayList<>();
            LongArray result = new LongArray();
            for (long id: regionIDs.getValues()) {
                Optional<Region> region = regionRepository.findById(id);
                if (region.isPresent()) {
                    if (region.get().getSymbols() != null && !region.get().getSymbols().isEmpty()) {
                        throw new IM3WSException("A region has symmbols inside, it cannot be deleted");
                    }
                    regions.add(region.get());
                    result.add(id);
                }
            }

            regionRepository.deleteAll(regions);
            return result;
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot delete page", e);
        }
    }

    // revisado hasta aquí







    @Transactional
    @PostMapping(path = "docAnalyze")
    public List<Page> analyzeDocument(@RequestBody DocAnalysisForm request)
    {
        try {
            Image persistentImage = getImage(request.getImageID());
            Path imagePath = Paths.get(muretConfiguration.getFolder(), persistentImage.getDocument().getPath(),
                    MURETConfiguration.MASTER_IMAGES, persistentImage.getFilename());
            AutoDocumentAnalysisModel autoDocumentAnalysisModel = m_client.getDocumentAnalysis(request.getImageID(), imagePath, request.getModelToUse());
            return documentAnalysisModel.createAutomaticDocumentAnalysis(persistentImage, request.getNumPages(), autoDocumentAnalysisModel);
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot analyze document", e);
        }
    }

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
