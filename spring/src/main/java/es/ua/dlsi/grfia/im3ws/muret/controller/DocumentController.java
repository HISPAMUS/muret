package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.BinaryOutputWrapper;
import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.controller.StringResponse;
import es.ua.dlsi.grfia.im3ws.muret.auditing.AuditorAwareImpl;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.DocumentStatistics;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.PreflightCkeckResult;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.StringBody;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.UploadFileResponse;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.entity.Part;
import es.ua.dlsi.grfia.im3ws.muret.entity.State;
import es.ua.dlsi.grfia.im3ws.muret.model.NotationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentModel;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.PartRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.DocumentRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.StateRepository;
import es.ua.dlsi.grfia.im3ws.service.FileStorageService;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.utils.FileCompressors;
import es.ua.dlsi.im3.core.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private final StateRepository stateRepository;
    private final PartRepository partRepository;
    private final DocumentModel documentModel;
    private final NotationModel notationModel;

    @Autowired
    public DocumentController(DocumentModel documentModel, FileStorageService fileStorageService,
                              MURETConfiguration muretConfiguration, DocumentRepository documentRepository, ImageRepository imageRepository,
                              StateRepository stateRepository, PartRepository partRepository) {
        this.documentModel = documentModel;
        this.fileStorageService = fileStorageService;
        this.muretConfiguration = muretConfiguration;
        this.documentRepository = documentRepository;
        this.imageRepository = imageRepository;
        this.stateRepository = stateRepository;
        this.partRepository = partRepository;
        this.notationModel = new NotationModel();
    }

    @PostMapping(path = {"/new"})
    public Document newDocument(@RequestBody Document document) throws IM3WSException {
        return documentModel.newDocument(document);
    }


    // --- TODO usado hasta aquí ----

    // angular ng2-file-upload uploads files one by one
    @PostMapping("uploadDocumentImage")
    public UploadFileResponse uploadFile(@RequestParam("documentid") Integer documentid, @RequestParam("file") MultipartFile file) throws IM3Exception {

        //Logger.getLogger(this.getClass().getName()).log(Level.INFO, "User ID: " + AuditorAwareImpl.getCurrentUser().getId().toString());

        Optional<Document> document = documentRepository.findById(documentid);
        if (!document.isPresent()) {
            throw new RuntimeException("Document with id " + documentid + " does not exist");
        }

        Path mastersPath = Paths.get(muretConfiguration.getFolder(), document.get().getPath(),  MURETConfiguration.MASTER_IMAGES);

        String fileName = fileStorageService.storeFile(mastersPath, file);

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Uploading file {0} to document with id {1}", new Object[]{fileName, documentid});

        /*String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(document.get().getPath())
                .path(fileName)
                .toUriString();*/

        Path imagePath = mastersPath.resolve(fileName);
        BufferedImage fullImage = null;
        try {
            fullImage = ImageIO.read(imagePath.toFile());
        } catch (IOException e) {
            throw new IM3Exception(e);
        }

        Path thumbnailsPath = Paths.get(muretConfiguration.getFolder(), document.get().getPath(), MURETConfiguration.THUMBNAIL_IMAGES, fileName);
        createSecondaryImage(imagePath, thumbnailsPath, muretConfiguration.getThumbnailHeight());

        Path previewPath = Paths.get(muretConfiguration.getFolder(), document.get().getPath(), MURETConfiguration.PREVIEW_IMAGES, fileName);
        createSecondaryImage(imagePath, previewPath, muretConfiguration.getPreviewHeight());

        //TODO Atómico
        //TODO Ordenación
        Image image = new Image(fileName, null, fullImage.getWidth(), fullImage.getHeight(), document.get(), null, null);
        image.setCreatedBy(AuditorAwareImpl.getCurrentUser());
        imageRepository.save(image);

        return new UploadFileResponse(fileName, file.getContentType(), file.getSize());
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


    @GetMapping(path = {"/statistics/{id}"})
    @Transactional
    public DocumentStatistics getDocumentStatistics(@PathVariable("id") Integer id) throws IM3WSException {
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
    }

    @PutMapping("/composer/{documentID}")
    public void putComposer(@PathVariable int documentID, @RequestBody StringBody composer) throws IM3WSException {
        Optional<Document> document = documentRepository.findById(documentID);
        if (!document.isPresent()) {
            throw new IM3WSException("Cannot find a document with id " + documentID);
        }

        document.get().setComposer(composer.getValue());
        documentRepository.save(document.get());
    }

    @PutMapping("/comments/{documentID}")
    public void putComments(@PathVariable int documentID, @RequestBody StringBody comments) throws IM3WSException {
        Optional<Document> document = documentRepository.findById(documentID);
        if (!document.isPresent()) {
            throw new IM3WSException("Cannot find a document with id " + documentID);
        }

        document.get().setComments(comments.getValue());
        documentRepository.save(document.get());
    }

    @PutMapping("/state/{documentID}")
    public void putState(@PathVariable int documentID, @RequestBody(required=false) State state) throws IM3WSException {
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
    }

    @GetMapping(path = {"/exportFullScoreMEI/{documentID}/{selectedImages}"})
    @Transactional
    public StringResponse exportFullScoreMEI(@PathVariable("documentID") Integer documentID, @PathVariable("selectedImages") String selectedImages) throws IM3WSException {
        return exportMEI(documentID, null, selectedImages);
    }

    @GetMapping(path = {"/exportPartMEI/{documentID}/{partID}/{selectedImages}"})
    @Transactional
    public StringResponse exportPartMEI(@PathVariable("documentID") Integer documentID, @PathVariable("partID") Long partID, @PathVariable("selectedImages") String selectedImages) throws IM3WSException {
        return exportMEI(documentID, partID, selectedImages);
    }

    private StringResponse exportMEI(Integer documentID, Long partID, String selectedImages) throws IM3WSException {
        Optional<Document> document = documentRepository.findById(documentID);
        if (!document.isPresent()) {
            throw new IM3WSException("Cannot find a document with id " + documentID);
        }

        Part part = null;

        if (partID != null) {
            Optional<Part> opart = partRepository.findById(partID);
            if (!opart.isPresent()) {
                throw new IM3WSException("Cannot find a part with id " + partID);
            }
            part = opart.get();
        }

        Set<Long> idsOfSelectedImages = findSelectedImages(selectedImages);
        try {
            return new StringResponse(notationModel.exportMEI(document.get(), part, false, idsOfSelectedImages));
        } catch (IM3Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Error exporting MEI", e);
            throw new IM3WSException(e);
        }
    }

    @GetMapping(path = {"/exportMEIPartsFacsimile/{documentID}/{selectedImages}"})
    @Transactional
    public StringResponse exportMEIPartsFacsimile(@PathVariable("documentID") Integer documentID, @PathVariable("selectedImages") String selectedImages) throws IM3WSException {
        Optional<Document> document = documentRepository.findById(documentID);
        if (!document.isPresent()) {
            throw new IM3WSException("Cannot find a document with id " + documentID);
        }

        Set<Long> idsOfSelectedImages = findSelectedImages(selectedImages);
        try {
            return new StringResponse(notationModel.exportMEI(document.get(), null, true, idsOfSelectedImages));
        } catch (IM3Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Error exporting MEI parts facsimile", e);
            throw new IM3WSException(e);
        }
    }


    @RequestMapping(value="/exportMensurstrich/{documentID}/{selectedImages}", method= RequestMethod.GET, produces="application/x-gzip")
    @ResponseBody
    @Transactional
    public ResponseEntity<?> exportMensurstrich(@PathVariable Integer documentID, @PathVariable("selectedImages") String selectedImages)  {
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

            Set<Long> idsOfSelectedImages = findSelectedImages(selectedImages);
            notationModel.generateMensurstrich(tmpDirectory, document.get(), idsOfSelectedImages);

            fileCompressors.tgzFolders(tgz, files, prefixes);

            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Adding to output file name {0}", filename);
            output.setFilename(filename);
            byte[] data = Files.readAllBytes(tgz);
            output.setData(data);

            return new ResponseEntity<>(output.getData(), output.getHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot export", e);

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Cannot export: " + e.getMessage(), e);

        }
    }

    @RequestMapping(value="/exportMusicXML/{documentID}/{selectedImages}", method= RequestMethod.GET, produces="application/x-gzip")
    @ResponseBody
    @Transactional
    public ResponseEntity<?> exportMusicXML(@PathVariable Integer documentID, @PathVariable("selectedImages") String selectedImages) throws IM3WSException {
        Optional<Document> document = documentRepository.findById(documentID);
        if (!document.isPresent()) {
            throw new IM3WSException("Cannot find a document with id " + documentID);
        }

        try {
            FileCompressors fileCompressors = new FileCompressors();
            ArrayList<String> prefixes = new ArrayList<>();
            ArrayList<Path> files = new ArrayList<>();

            Path tgz = Files.createTempFile("musicxml_" + documentID, ".tar.gz");
            String filename = tgz.getFileName().toString();
            BinaryOutputWrapper output = new BinaryOutputWrapper("application/x-gzip");

            Path tmpDirectory = Files.createTempDirectory("musicxml_files_" + documentID); //TODO eliminar código duplicado (exportMensurstrich)
            prefixes.add("content");
            files.add(tmpDirectory);

            Set<Long> idsOfSelectedImages = findSelectedImages(selectedImages);
            notationModel.generateMusicXML(tmpDirectory, document.get(), idsOfSelectedImages);

            fileCompressors.tgzFolders(tgz, files, prefixes);

            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Adding to output file name {0}", filename);
            output.setFilename(filename);
            byte[] data = Files.readAllBytes(tgz);
            output.setData(data);

            return new ResponseEntity<>(output.getData(), output.getHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot export", e);
            throw new IM3WSException(e);

        }
    }

    private Set<Long> findSelectedImages(String selectedImages) {
        String [] imageIDStr = selectedImages.split(",");
        TreeSet<Long> result = new TreeSet<>();
        for (String imageID: imageIDStr) {
            result.add(Long.parseLong(imageID));
        }
        return result;
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
        Optional<Document> document = documentRepository.findById(documentID);
        if (!document.isPresent()) {
            throw new IM3WSException("Cannot find a document with id " + documentID);
        }

        Set<Long> idsOfSelectedImages = findSelectedImages(selectedImages);

        return notationModel.preflightCheck(document.get(), idsOfSelectedImages);
    }
}
