package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentModel;
import es.ua.dlsi.grfia.im3ws.muret.model.ImageRecognitionModel;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    ImageRecognitionProgressStatusRepository imageRecognitionProgressStatusRepository;
    private final StateRepository stateRepository;

    @Autowired
    public ImageRecognitionController(DocumentModel documentModel,
                                      MURETConfiguration muretConfiguration, DocumentRepository documentRepository,
                                      ImageRepository imageRepository, StateRepository stateRepository,
                                      ImageRecognitionProgressStatusRepository imageRecognitionProgressStatusRepository) {
        this.muretConfiguration = muretConfiguration;
        this.documentRepository = documentRepository;
        this.imageRepository = imageRepository;
        this.stateRepository = stateRepository;
        this.imageRecognitionProgressStatusRepository = imageRecognitionProgressStatusRepository;
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
            result.setFilename(image.get().getFilename());
            Document document = image.get().computeDocument();
            result.setDocumentID(document.getId());
            result.setDocumentPath(document.getPath());
            result.setManuscriptType(document.getManuscriptType());
            result.setNotationType(document.getNotationType());
            result.setComments(image.get().getComments());
            ArrayList<Part> sortedParts = new ArrayList<>(document.getParts());
            Collections.sort(sortedParts);
            result.setDocumentParts(sortedParts);
            result.setImagePart(image.get().getPart());
            result.setHidden(image.get().isHidden());
            result.setImageRecognitionProgressStatuses(image.get().getImageRecognitionProgressStatuses());
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

    /**
     * It returns the status set
     * @return
     */
    @PutMapping("/progressStatus")
    public Set<ImageRecognitionProgressStatus> progressStatus(@RequestBody ImageRecognitionProgressStatusChange progressStatusChange)  {
        try {
            Optional<Image> image = imageRepository.findById(progressStatusChange.getImageID());
            if (!image.isPresent()) {
                throw new IM3WSException("Cannot find an image with id " + progressStatusChange.getImageID());
            }

            Set<ImageRecognitionProgressStatus> statuses = imageRecognitionProgressStatusRepository.findByImageAndPhase(image.get(), progressStatusChange.getPhase());
            ImageRecognitionProgressStatus imageRecognitionProgressStatus;
            if (statuses == null || statuses.isEmpty()) {
                imageRecognitionProgressStatus = new ImageRecognitionProgressStatus();
                imageRecognitionProgressStatus.setImage(image.get());
                imageRecognitionProgressStatus.setPhase(progressStatusChange.getPhase());
                imageRecognitionProgressStatus.setStatus(progressStatusChange.getStatus());
                ImageRecognitionProgressStatus object = imageRecognitionProgressStatusRepository.save(imageRecognitionProgressStatus);
                statuses.add(object);
            } else if (statuses.size() > 1) {
                throw new IM3WSException("Found more than one status for the ImageRecognitionProgressStatus");
            } else {
                imageRecognitionProgressStatus = statuses.iterator().next();
                imageRecognitionProgressStatus.setStatus(progressStatusChange.getStatus());
                imageRecognitionProgressStatusRepository.save(imageRecognitionProgressStatus);
            }

            return statuses;
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot put comments", e);
        }
    }
}
