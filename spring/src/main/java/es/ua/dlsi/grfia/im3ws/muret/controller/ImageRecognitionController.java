package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.BinaryOutputWrapper;
import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.controller.StringResponse;
import es.ua.dlsi.grfia.im3ws.muret.auditing.AuditorAwareImpl;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentModel;
import es.ua.dlsi.grfia.im3ws.muret.model.ImageRecognitionModel;
import es.ua.dlsi.grfia.im3ws.muret.model.NotationModel;
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
@RequestMapping("imageRecognition")
@RestController
public class ImageRecognitionController {
    private final MURETConfiguration muretConfiguration;
    private final DocumentRepository documentRepository;
    private final ImageRepository imageRepository;

    private final StateRepository stateRepository;

    @Autowired
    public ImageRecognitionController(DocumentModel documentModel,
                                      MURETConfiguration muretConfiguration, DocumentRepository documentRepository,
                                      ImageRepository imageRepository, StateRepository stateRepository) {
        this.muretConfiguration = muretConfiguration;
        this.documentRepository = documentRepository;
        this.imageRepository = imageRepository;
        this.stateRepository = stateRepository;
    }


    @GetMapping(path = {"/overview/{imageID}"})
    @Transactional(readOnly = true)
    public ImageOverview getImageOverview(@PathVariable("imageID") Long id)  {
        try {
            Optional<Image> image = imageRepository.findById(id);
            if (!image.isPresent()) {
                throw new IM3WSException("Cannot find an image with id " + id);
            }

            ImageOverview result = new ImageOverview();
            result.setImageID(id);
            Document document = null;
            if (image.get().getDocument() != null) {
                document = image.get().getDocument();
            } else {
                document = image.get().getSection().getDocument();
            }
            result.setDocumentID(document.getId());
            result.setDocumentPath(document.getPath());
            result.setComments(image.get().getComments());
            ArrayList<Part> sortedParts = new ArrayList<>(document.getParts());
            Collections.sort(sortedParts);
            result.setDocumentParts(sortedParts);
            result.setImagePart(image.get().getPart());
            return result;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot create statistics", e);
        }
    }


    /**
     *
     * @param imageID
     * @return Parts with region and symbol information
     */
    @GetMapping(path = {"/pagesRegionsSymbols/{imageID}"})
    // @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Set<Page> getPagesRegionsSymbols(@PathVariable("imageID") Long imageID)  {
        try {
            Optional<Image> image = imageRepository.findById(imageID);
            if (!image.isPresent()) {
                throw new IM3WSException("Cannot find an image with id " + imageID);
            }

            return new ImageRecognitionModel().getPagesRegionsSymbols(image.get());
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot create statistics", e);
        }
    }

    /**
     * It returns the comments set
     * @return
     */
    @PutMapping("/comments/{imageID}")
    public String putComments(@PathVariable("imageID") long imageID, @RequestBody(required=false) String comments)  {
        try {
            Optional<Image> image = imageRepository.findById(imageID);
            if (!image.isPresent()) {
                throw new IM3WSException("Cannot find an image with id " + imageID);
            }

            image.get().setComments(comments);
            imageRepository.save(image.get());
            return image.get().getComments();
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot put comments", e);
        }
    }
}
