package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.BinaryOutputWrapper;
import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.controller.StringResponse;
import es.ua.dlsi.grfia.im3ws.muret.auditing.AuditorAwareImpl;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.NotationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentModel;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import es.ua.dlsi.grfia.im3ws.service.FileStorageService;
import es.ua.dlsi.grfia.im3ws.service.Utils;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.utils.FileCompressors;
import es.ua.dlsi.im3.core.utils.FileUtils;
import es.ua.dlsi.im3.core.utils.ImageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// !!! Important: no controller should launch any exception
// See complete file in https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/
/**
 * Used to upload document images to the server
 */
//@CrossOrigin("${angular.url}")
@RequestMapping("document")
@RestController
public class DocumentController {
    private final FileStorageService fileStorageService;
    private final MURETConfiguration muretConfiguration;
    private final DocumentRepository documentRepository;
    private final ImageRepository imageRepository;
    private final SectionRepository sectionRepository;


    private final StateRepository stateRepository;
    private final PartRepository partRepository;
    private final DocumentModel documentModel;
    private final NotationModel notationModel;


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public DocumentController(DocumentModel documentModel, FileStorageService fileStorageService,
                              MURETConfiguration muretConfiguration, DocumentRepository documentRepository, ImageRepository imageRepository,
                              StateRepository stateRepository, PartRepository partRepository, SectionRepository sectionRepository) {
        this.documentModel = documentModel;
        this.fileStorageService = fileStorageService;
        this.muretConfiguration = muretConfiguration;
        this.documentRepository = documentRepository;
        this.imageRepository = imageRepository;
        this.stateRepository = stateRepository;
        this.partRepository = partRepository;
        this.sectionRepository = sectionRepository;
        this.notationModel = new NotationModel();
    }

    private <O extends IOrdered, R extends CrudRepository> void updateOrdering(R repository, List<O> entities) {
        ArrayList<O> toUpdate = new ArrayList<>();
        for (int i=0; i<entities.size(); i++) {
            O entity = entities.get(i);
            if (entity.getOrdering() != i) {
                entity.setOrdering(i);
                toUpdate.add(entity);
            }
        }
        repository.saveAll(toUpdate);
    }


    private <O extends IOrdered, R extends CrudRepository> NumberArray<Long> setOrdering(R repository, NumberArray<Long> ordering, String entityName) {
        final ArrayList<O> updatedEntities = new ArrayList<>();
        int i=0;
        NumberArray<Long> orderingLong = new NumberArray<Long>();
        for (Long id: ordering.getValues()) {
            Optional<O> entity = repository.findById(id);
            if (!entity.isPresent()) {
                throw new RuntimeException("Cannot find " + entityName + " with id " + id);
            }
            entity.get().setOrdering(i);
            updatedEntities.add(entity.get());
            orderingLong.add(id);
            i++;
        }

        repository.saveAll(updatedEntities);
        return orderingLong;
    }

    @PutMapping(path = {"/moveImagesToSection"})
    @javax.transaction.Transactional
    public SectionImages moveImageToSection(@RequestBody SectionImages sectionImages) {
        try {
            java.util.Collection<Image> images = new ArrayList<>();
            Long [] previousSectionIDs = new Long[sectionImages.getImageIDS().length];
            for (int i=0; i<sectionImages.getImageIDS().length; i++) {
                Long id = sectionImages.getImageIDS()[i];
                Optional<Image> image = imageRepository.findById(id);
                if (!image.isPresent()) {
                    throw new IM3WSException("Cannot find an image with ID= " + id);
                }
                if (image.get().getSection() == null) {
                    previousSectionIDs[i] = null;
                } else {
                    previousSectionIDs[i] = image.get().getSection().getId();
                }

                if (sectionImages.getNewSectionID() == null) {
                    // add to the previous document
                    image.get().changeDocumentAndSection(image.get().getSection().getDocument(), null);
                    updateOrdering(imageRepository, image.get().getDocument().getImages());
                } else {
                    Optional<Section> section = sectionRepository.findById(sectionImages.getNewSectionID());
                    if (!section.isPresent()) {
                        throw new IM3WSException("Cannot find a section with ID= " + sectionImages.getNewSectionID());
                    }
                    image.get().changeDocumentAndSection(null, section.get());
                    updateOrdering(imageRepository, image.get().getSection().getImages());
                }
                images.add(image.get());
            }

            imageRepository.saveAll(images);
            sectionImages.setPreviousSectionIDs(previousSectionIDs);
            return sectionImages;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot move image to section", e);
        }
    }

    @PutMapping(path = {"/moveImagesToDefaultSection/{documentID}"})
    @javax.transaction.Transactional
    public Section moveImageToDefaultSection(@PathVariable("documentID") Integer documentID) {
        try {
            Optional<Document> document = documentRepository.findById(documentID);
            if (!document.isPresent()) {
                throw new IM3WSException("Cannot find document with id=" + documentID);
            }

            Section defaultSection = new Section();
            defaultSection.setName("Default");
            defaultSection.setDocument(document.get());
            defaultSection.setOrdering(0);
            Section savedSection = sectionRepository.save(defaultSection);
            int ordering = 0;
            for (Image image: document.get().getImages()) {
                image.setOrdering(ordering);
                image.setDocument(null);
                image.setSection(savedSection);
                ordering++;
            }
            imageRepository.saveAll(document.get().getImages());
            return savedSection;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot create default section and move images", e);
        }
    }

    // TO-DO Debería ser POST (https://arquitecturaibm.com/diferencia-entre-put-y-post-en-un-web-service-rest-en-java/)
    @PutMapping(path = {"/createSection/{documentID}/{name}"})
    @Transactional
    public Section createSection(@PathVariable("documentID") Integer documentID, @PathVariable("name") String name) {
        try {
            Optional<Document> document = documentRepository.findById(documentID);
            if (!document.isPresent()) {
                throw new IM3WSException("Cannot find document with id=" + documentID);
            }

            Section section = new Section();
            section.setDocument(document.get());
            section.setName(name);
            int max = 0;
            for (Section s: document.get().getSections()) {
                max = Math.max(max, s.getOrdering());
            }
            section.setOrdering(max+1);
            Section createdSection = sectionRepository.save(section);
            return createdSection;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot create new section", e);
        }
    }

    @PutMapping(path = {"/renameSection/{sectionID}/{name}"})
    @Transactional
    public Section renameSection(@PathVariable("sectionID") Long sectionID, @PathVariable("name") String name) {
        try {
            Optional<Section> optionalSection = sectionRepository.findById(sectionID);
            if (!optionalSection.isPresent()) {
                throw new IM3WSException("Cannot find section with id=" + sectionID);
            }
            optionalSection.get().setName(name);

            // avoid returning section with images and document
            sectionRepository.save(optionalSection.get());
            Section result = new Section();
            result.setId(sectionID);
            result.setName(name);
            return result;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot save section", e);
        }
    }


    @PutMapping(path = {"/reorderSections"})
    @Transactional
    public NumberArray<Long> reorderSections(@RequestBody LongArray ordering) {
        try {
            return setOrdering(sectionRepository, ordering, "section");
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot save sections reordering", e);
        }
    }

    /**
     * @return sectionIDsOrdering Comma separated list of IDS
     */
    @PutMapping(path = {"/reorderImages"})
    @Transactional
    public NumberArray<Long> reorderImages(@RequestBody LongArray ordering) {
        try {
            return setOrdering(imageRepository, ordering, "image");
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot save image reordering", e);
        }
    }

    /**
     * Return the deleted section
     * @param sectionID
     * @return
     */
    @DeleteMapping(path = {"/deleteSection/{sectionID}"})
    @Transactional
    public Long deleteSection(@PathVariable("sectionID") Long sectionID) {
        try {
            Optional<Section> optionalSection = sectionRepository.findById(sectionID);
            if (!optionalSection.isPresent()) {
                throw new IM3WSException("Cannot find section with id=" + sectionID);
            }
            // first move all the images in the section to the main document
            Document document = optionalSection.get().getDocument();
            ArrayList<Image> changedImages = new ArrayList<>();
            for (Image image: optionalSection.get().getImages()) {
                image.setSection(null);
                image.setDocument(document);
                changedImages.add(image);
            }
            imageRepository.saveAll(changedImages);
            sectionRepository.delete(optionalSection.get());
            return sectionID;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot delete section", e);
        }
    }

    @GetMapping(path = {"/partsInImages/{documentID}"})
    @Transactional(readOnly = true)
    public Set<PartsInImage> getPartsInImages(@PathVariable("documentID") Integer id)  {
        try {
            Optional<Document> document = documentRepository.findById(id);
            if (!document.isPresent()) {
                throw new IM3WSException("Cannot find a document with id " + id);
            }

            HashSet<PartsInImage> result = getPartsInImages(document.get());
            return result;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get parts in images", e);
        }
    }

    private HashSet<PartsInImage> getPartsInImages(Document document) {
        HashSet<PartsInImage> result = new HashSet<>();
        for (Image image : document.getImages()) {
            result.add(fillPartsInImage(image));
        }

        for (Section section: document.getSections()) {
            for (Image image: section.getImages()) {
                PartsInImage partsInImage = fillPartsInImage(image);
                if (!partsInImage.getIdsOfParts().isEmpty()) {
                    result.add(partsInImage);
                }
            }
        }
        return result;
    }

    private PartsInImage fillPartsInImage(Image image) {
        PartsInImage partsInImage = new PartsInImage(image.getId());
        if (image.getPart() != null) {
            partsInImage.addPart(image.getPart().getId());
        }

        for (Page page: image.getPages()) {
            if (page.getPart() != null) {
                partsInImage.addPart(page.getPart().getId());
            }
            for (Region region: page.getRegions()) {
                if (region.getPart() != null) {
                    partsInImage.addPart(region.getPart().getId());
                }
            }
        }

        return partsInImage;
    }

    /**
     * @param partID
     * @param imageIds
     * @return All parts in image again
     */
    @PutMapping(path = {"/linkImagesToPart/{partID}"})
    @javax.transaction.Transactional
    public HashSet<PartsInImage> linkImagesToPart(@PathVariable("partID") Long partID, @RequestBody LongArray imageIds) {
        try {
            Optional<Part> optionalPart = partRepository.findById(partID);
            if (!optionalPart.isPresent()) {
                throw new IM3WSException("Cannot find a part with id " + partID);
            }

            Part part = optionalPart.get();
            return linkImagesToPart(imageIds, part);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot linl images to part", e);
        }
    }

    @PutMapping(path = {"/unlinkImagesFromPart"})
    @javax.transaction.Transactional
    public HashSet<PartsInImage> unlinkImagesFromPart(@RequestBody LongArray imageIds) {
        try {
            Document document = null;
            ArrayList<Image> changedImages = new ArrayList<>();

            for (Long imageID: imageIds.getValues()) {
                Image image = findImage(imageID);

                if (document == null) { // lookup first document
                    document = image.computeDocument();
                }

                image.setPart(null);
                changedImages.add(image);
            }
            imageRepository.saveAll(changedImages);
            return getPartsInImages(document);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot linl images to part", e);
        }
    }

    /**
     * @return All parts in image again
     */
    @PostMapping(path = {"/linkImagesToNewPart/{partName}"})
    @javax.transaction.Transactional
    public ImagesInNewPart linkImagesToNewPart(@PathVariable("partName") String partName, @RequestBody LongArray imageIds) {
        try {
            if (imageIds.getValues().isEmpty()) {
                throw new IM3WSException("No image given");
            }

            Image image = findImage(imageIds.getValues().get(0));
            Document document = image.computeDocument();
            Part part = new Part();
            part.setDocument(document);
            part.setName(partName);
            part.setOrdering(document.computeNextPartOrdering());
            Part savedPart = partRepository.save(part);

            ImagesInNewPart imagesInNewPart = new ImagesInNewPart();
            imagesInNewPart.setPart(savedPart);
            HashSet<PartsInImage> partsInImages = linkImagesToPart(imageIds, savedPart);
            imagesInNewPart.setPartsInImage(partsInImages);
            return imagesInNewPart;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot create part and link to image", e);
        }
    }

    private HashSet<PartsInImage> linkImagesToPart(LongArray imageIds, Part part) throws IM3WSException {
        Document document = null;
        ArrayList<Image> changedImages = new ArrayList<>();

        for (Long imageID: imageIds.getValues()) {
            Image image = findImage(imageID);

            if (document == null) { // lookup first document
                document = image.computeDocument();
            }

            image.setPart(part);
            changedImages.add(image);
        }

        imageRepository.saveAll(changedImages);
        return getPartsInImages(document);
    }

    private Image findImage(Long imageID) throws IM3WSException {
        Optional<Image> image = imageRepository.findById(imageID);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + imageID);
        }
        return image.get();
    }


    @PutMapping(path = {"/changeImagesVisibility"})
    @javax.transaction.Transactional
    public ImagesVisibility changeImagesVisibility(@RequestBody ImagesVisibility imagesVisibility) {
        try {
            ArrayList<Image> changedImages = new ArrayList<>();

            for (Long imageID: imagesVisibility.getImageIDS().getValues()) {
                Image image = findImage(imageID);

                image.setHidden(imagesVisibility.isHidden());
                changedImages.add(image);
            }
            imageRepository.saveAll(changedImages);
            return imagesVisibility;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot linl images to part", e);
        }
    }

    //TODO Move to another controller
    @PostMapping(path = {"/exportFullScoreMEI"})
    @Transactional
    public StringResponse exportFullScoreMEI(@RequestBody LongArray selectedImages) {
        try {
            return exportMEI(null, selectedImages);
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot export MEI", e);
        }
    }

    @PostMapping(path = {"/exportPartMEI/{partID}"})
    @Transactional
    public StringResponse exportPartMEI(@PathVariable("partID") Long partID, @RequestBody LongArray selectedImages)  {
        try {
            return exportMEI(partID, selectedImages);
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot export parts MEI", e);
        }
    }

    private Document getDocumentOfSelectedImages(LongArray selectedImages) throws IM3WSException {
        if (selectedImages.getValues().isEmpty()) {
            throw new IM3WSException("No selected images");
        }

        // get the document the first image belongs to
        Optional<Image> image = imageRepository.findById(selectedImages.getValues().get(0));
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find image with id = " + selectedImages.getValues().get(0));
        }
        Document document = image.get().computeDocument();
        return document;
    }

    private StringResponse exportMEI(Long partID, LongArray selectedImages) throws IM3WSException {
        Part part = null;


        if (partID != null) {
            Optional<Part> opart = partRepository.findById(partID);
            if (!opart.isPresent()) {
                throw new IM3WSException("Cannot find a part with id " + partID);
            }
            part = opart.get();
        }

        try {
            Document document = getDocumentOfSelectedImages(selectedImages);
            return new StringResponse(notationModel.exportMEI(documentModel, document, part, false, true, selectedImages.getValues()));
        } catch (IM3Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Error exporting MEI", e);
            throw new IM3WSException(e);
        }
    }

    private StringResponse exportMEIPartsFacsimile(LongArray selectedImages, boolean exportMeasuringPolyphony) {
        try {
            Document document = getDocumentOfSelectedImages(selectedImages);
            return new StringResponse(notationModel.exportMEI(documentModel, document, null, true, !exportMeasuringPolyphony, selectedImages.getValues()));
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot export MEI with facsimile", e);
        }
    }
    @PostMapping(path = {"/exportMEIPartsFacsimile"})
    @Transactional
    public StringResponse exportMEIPartsFacsimile(@RequestBody LongArray selectedImages) {
        return exportMEIPartsFacsimile(selectedImages, false);
    }

    @PostMapping(path = {"/exportMeasuringPolyphony"})
    @Transactional
    public StringResponse exportMeasuringPolyphony(@RequestBody LongArray selectedImages) {
        return exportMEIPartsFacsimile(selectedImages, true);
    }


    // revisado hasta aquí

    @PostMapping(path = {"/new"})
    public Document newDocument(@RequestBody Document document) throws IM3WSException {
        return documentModel.newDocument(document);
    }


    @GetMapping(path = {"/statistics/{id}"})
    @Transactional
    public DocumentStatistics getDocumentStatistics(@PathVariable("id") Integer id)  {
        try {
            Optional<Document> document = documentRepository.findById(id);
            if (!document.isPresent()) {
                throw new IM3WSException("Cannot find a document with id " + id);
            }

            //TODO All this could be done in just one query with a union
            int documentID = document.get().getId();
            DocumentStatistics documentStatistics = new DocumentStatistics();
            documentStatistics.setAgnosticSymbols(documentRepository.getNumberOfAgnosticSymbols(documentID));
            documentStatistics.setImages(document.get().getImages().size());
            documentStatistics.setPages(documentRepository.getNumberOfPages(documentID));
            documentStatistics.setRegions(documentRepository.getNumberOfRegions(documentID));
            documentStatistics.setStaves(documentRepository.getNumberOfStaves(documentID));

            return documentStatistics;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot create statistics", e);
        }
    }


    // --- TODO usado hasta aquí ----

    // angular ng2-file-upload uploads files one by one
    @PostMapping("uploadDocumentImages")
    public UploadFileResponse uploadDocumentImage(@RequestParam("documentid") Integer documentid, @RequestParam("file") MultipartFile file) {
        try {
            //Logger.getLogger(this.getClass().getName()).log(Level.INFO, "User ID: " + AuditorAwareImpl.getCurrentUser().getId().toString());
            Optional<Document> document = documentRepository.findById(documentid);
            if (!document.isPresent()) {
                throw new RuntimeException("Document with id " + documentid + " does not exist");
            }

            Path tmpFolder = muretConfiguration.getTmpFolder();
            String fileName = fileStorageService.storeFile(tmpFolder, file);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Uploading file {0} to document with id {1}", new Object[]{fileName, documentid});

            // check the type of file
            Path filePath = tmpFolder.resolve(fileName);
            Utils utils = new Utils();
            if (utils.isImageFile(filePath.toFile())) {
                storeImageInDocument(document, fileName, filePath);
            } else if (utils.isPDF(filePath.toFile())) {
                Path tempToExtractPDF = Files.createTempDirectory(tmpFolder, FileUtils.getFileWithoutPathOrExtension(fileName));
                List<File> extractedImages = utils.extractImagesFromPDF(filePath.toFile(), tempToExtractPDF.toFile());

                // add leading zeros
                String baseFileName = FileUtils.getFileWithoutPathOrExtension(fileName);
                int digits = (int)Math.log10(extractedImages.size());
                int npage = 1;
                for (File extractedImage: extractedImages) {
                    String suffix = StringUtils.leftPad(Integer.toString(npage), digits, '0');
                    String pageFileName = baseFileName + "_" + suffix + ".jpg";
                    storeImageInDocument(document, pageFileName, extractedImage.toPath());
                    npage++;
                }
            }

            return new UploadFileResponse(fileName, file.getContentType(), file.getSize());
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot upload file", e);
        }
    }

    private void storeImageInDocument(Optional<Document> document, String fileName, Path filePath) throws IM3Exception {
        Path mastersPath = Paths.get(muretConfiguration.getFolder(), document.get().getPath(),  MURETConfiguration.MASTER_IMAGES, fileName);
        Path thumbnailsPath = Paths.get(muretConfiguration.getFolder(), document.get().getPath(), MURETConfiguration.THUMBNAIL_IMAGES, fileName);
        Path previewPath = Paths.get(muretConfiguration.getFolder(), document.get().getPath(), MURETConfiguration.PREVIEW_IMAGES, fileName);

        BufferedImage fullImage = null;
        try {
            fullImage = ImageIO.read(filePath.toFile());
            createSecondaryImage(filePath, thumbnailsPath, muretConfiguration.getThumbnailHeight());
            createSecondaryImage(filePath, previewPath, muretConfiguration.getPreviewHeight());
            // move to master
            Files.move(filePath, mastersPath);
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Error with file {0}, deleting it. Exception {1}", new Object[]{fileName, e});
            throw new IM3Exception(e);
        }

        //TODO Atómico
        //TODO Ordenación
        Image image = new Image(fileName, null, fullImage.getWidth(), fullImage.getHeight(), document.get(), null, null, null, null);
        image.setCreatedBy(AuditorAwareImpl.getCurrentUser());
        imageRepository.save(image);
    }


    private void createSecondaryImage(Path inputImagePath, Path outputImagePath, int height) throws IM3Exception {
        ImageUtils.getInstance().scaleToFitHeight(inputImagePath.toFile(), outputImagePath.toFile(), height);
    }

    // angular ng2-file-upload uses file as parameter name
    /*@PostMapping("documentImages")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("documentid") Integer documentid, @RequestParam("files") MultipartFile[] files) {


        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Uploading {0} files to document with id {1}", new Object[]{files==null?0:files.length, documentid});
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }*/


    @PutMapping("/composer/{documentID}")
    public void putComposer(@PathVariable int documentID, @RequestBody StringBody composer)  {
        try {
            Optional<Document> document = documentRepository.findById(documentID);
            if (!document.isPresent()) {
                throw new IM3WSException("Cannot find a document with id " + documentID);
            }

            document.get().setComposer(composer.getValue());
            documentRepository.save(document.get());
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot put composer", e);
        }
    }

    @PutMapping("/comments/{documentID}")
    public void putComments(@PathVariable int documentID, @RequestBody StringBody comments) {
        try {
            Optional<Document> document = documentRepository.findById(documentID);
            if (!document.isPresent()) {
                throw new IM3WSException("Cannot find a document with id " + documentID);
            }

            document.get().setComments(comments.getValue());
            documentRepository.save(document.get());
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot put comments", e);
        }
    }

    @PutMapping("/state/{documentID}")
    public void putState(@PathVariable int documentID, @RequestBody(required=false) State state)  {
        try {
            Optional<Document> document = documentRepository.findById(documentID);
            if (!document.isPresent()) {
                throw new IM3WSException("Cannot find a document with id " + documentID);
            }

            State persistedState;
            if (document.get().getState() == null) {
                persistedState = stateRepository.save(state);
                document.get().setState(persistedState);
                documentRepository.save(document.get());

            } else {
                if (state == null) {
                    State prevState = document.get().getState();
                    document.get().setState(null);
                    documentRepository.save(document.get());
                    // delete state
                    stateRepository.delete(prevState);
                } else {
                    // update state
                    persistedState = document.get().getState();
                    persistedState.setState(state.getState());
                    persistedState.setChangedBy(state.getChangedBy());
                    persistedState.setComments(state.getComments());
                    stateRepository.save(persistedState);
                }
            }
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot put state", e);
        }
    }

    //TODO
    @RequestMapping(value="/exportMensurstrich/{documentID}/{selectedImages}", method= RequestMethod.GET, produces="application/x-gzip")
    @ResponseBody
    @Transactional
    public ResponseEntity<?> exportMensurstrich(@PathVariable Integer documentID, @RequestBody LongArray selectedImages)  {
        try {
            Optional<Document> document = documentRepository.findById(documentID);
            if (!document.isPresent()) {
                throw new IM3WSException("Cannot find a document with id " + documentID);
            }

            FileCompressors fileCompressors = new FileCompressors();
            ArrayList<String> prefixes = new ArrayList<>();
            ArrayList<Path> files = new ArrayList<>();

            Path tgz = Files.createTempFile("mensurstrich_" + documentID, ".tar.gz");
            String filename = tgz.getFileName().toString();
            BinaryOutputWrapper output = new BinaryOutputWrapper("application/x-gzip");

            Path tmpDirectory = Files.createTempDirectory("mensurstrich_files_" + documentID);
            prefixes.add("content");
            files.add(tmpDirectory);

            notationModel.generateMensurstrich(documentModel, tmpDirectory, document.get(), selectedImages.getValues());

            fileCompressors.tgzFolders(tgz, files, prefixes);

            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Adding to output file name {0}", filename);
            output.setFilename(filename);
            byte[] data = Files.readAllBytes(tgz);
            output.setData(data);

            return new ResponseEntity<>(output.getData(), output.getHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            throw ControllerUtils.createServerError(this, "Cannot export mensurstrich", e);
        }
    }

    //TODO
    @RequestMapping(value="/exportMusicXML/{documentID}", method= RequestMethod.GET, produces="application/x-gzip")
    @ResponseBody
    @Transactional
    public ResponseEntity<?> exportMusicXML(@PathVariable Integer documentID, @RequestBody LongArray selectedImages) throws IM3WSException {
        try {
            Optional<Document> document = documentRepository.findById(documentID);
            if (!document.isPresent()) {
                throw new IM3WSException("Cannot find a document with id " + documentID);
            }
            FileCompressors fileCompressors = new FileCompressors();
            ArrayList<String> prefixes = new ArrayList<>();
            ArrayList<Path> files = new ArrayList<>();

            Path tgz = Files.createTempFile("musicxml_" + documentID, ".tar.gz");
            String filename = tgz.getFileName().toString();
            BinaryOutputWrapper output = new BinaryOutputWrapper("application/x-gzip");

            Path tmpDirectory = Files.createTempDirectory("musicxml_files_" + documentID); //TODO eliminar código duplicado (exportMensurstrich)
            prefixes.add("content");
            files.add(tmpDirectory);

            notationModel.generateMusicXML(documentModel, tmpDirectory, document.get(), selectedImages.getValues());

            fileCompressors.tgzFolders(tgz, files, prefixes);

            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Adding to output file name {0}", filename);
            output.setFilename(filename);
            byte[] data = Files.readAllBytes(tgz);
            output.setData(data);

            return new ResponseEntity<>(output.getData(), output.getHeaders(), HttpStatus.OK);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot export MusicXML", e);
        }
    }

    /**
     * @deprecated Use the AlignmentPreviewController
      * @param documentID
     * @param selectedImages
     * @return
     * @throws IM3WSException
     */
    @GetMapping(path = {"/preflightCheck/{documentID}/{selectedImages}"})
    @Transactional
    public PreflightCkeckResult exportPartMEI(@PathVariable("documentID") Integer documentID, @PathVariable("selectedImages") String selectedImages) throws IM3WSException {
        /*Optional<Document> document = documentRepository.findById(documentID);
        if (!document.isPresent()) {
            throw new IM3WSException("Cannot find a document with id " + documentID);
        }

        Set<Long> idsOfSelectedImages = findSelectedImages(selectedImages);

        return notationModel.preflightCheck(document.get(), idsOfSelectedImages);*/
        return null;
    }


}
