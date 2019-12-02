package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.controller.StringResponse;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.ClassifierModel;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.ClassifierModelTypes;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.UploadModel;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.entity.ManuscriptType;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.grfia.im3ws.muret.model.ClassifierClient;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.service.FileStorageService;
import es.ua.dlsi.im3.core.score.NotationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
@RequestMapping("classifierModels")
@RestController
public class ClassifierModelsController {
    private final ClassifierClient classifierClient;
    private final ImageRepository imageRepository;
    private final FileStorageService fileStorageService;
    private final MURETConfiguration muretconfig;

    @Autowired
    public ClassifierModelsController(MURETConfiguration muretConfiguration, ImageRepository imageRepository, FileStorageService fileStorageService, MURETConfiguration config) {
        classifierClient = new ClassifierClient(muretConfiguration.getPythonclassifiers());
        this.imageRepository = imageRepository;
        this.fileStorageService = fileStorageService;
        this.muretconfig = config;
    }

    /*@GetMapping(path = {"symbols/{collectionID}/{projectID}/{notationType}/{manuscriptType}"})
    public List<ClassifierModel> getSymbolClassifierModels(@PathVariable("collectionID") Long collectionID,
                                                           @PathVariable("projectID") Long projectID,
                                                           @PathVariable("notationType") String notationType,
                                                           @PathVariable("manuscriptType") String manuscriptType
    ) throws IM3WSException {
        try {
            return this.classifierClient.getModels(ClassifierModelTypes.eAgnosticSymbols, collectionID, projectID, notationType, manuscriptType);
        } catch (IM3WSException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot get classifier models", e);
            throw e;
        }
    }

    @GetMapping(path = {"agnosticEnd2End/{collectionID}/{projectID}/{notationType}/{manuscriptType}"})
    public List<ClassifierModel>  getAgnosticEnd2EndClassifierModel(@PathVariable("collectionID") Long collectionID,
                                            @PathVariable("projectID") Long projectID,
                                            @PathVariable("notationType") String notationType,
                                            @PathVariable("manuscriptType") String manuscriptType
    ) throws IM3WSException {
        try {
            return this.classifierClient.getModels(ClassifierModelTypes.eAgnosticEnd2End, collectionID, projectID, notationType, manuscriptType);
        } catch (IM3WSException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot get classifier models", e);
            throw new IM3WSException("There was an error retrieving Agnostic End to end models, it is possible that the folder referenced does not exist in the classification server");
        }
    }*/

    private Project getProject(Long imageID) throws IM3WSException {
        Optional<Image> image = imageRepository.findById(imageID);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find image with ID " + imageID);
        }

        Project project = image.get().getProject();
        return project;
    }
    @GetMapping(path = {"symbols/{imageID}"})
    @Transactional
    public List<ClassifierModel> getSymbolClassifierModels(@PathVariable("imageID") Long imageID) throws IM3WSException {
        try {
            Project project = getProject(imageID);
            NotationType notationType = project.getNotationType();
            ManuscriptType manuscriptType = project.getManuscriptType();
            Integer projectID = project.getId();
            Integer collectionID = project.getCollection().getId();

            return this.classifierClient.getModels(ClassifierModelTypes.eAgnosticSymbols, collectionID, projectID, notationType.name(), manuscriptType.name());
        } catch (IM3WSException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot get classifier models", e);
            throw e;
        }
    }

    @GetMapping(path = {"agnosticEnd2End/{imageID}"})
    @Transactional
    public List<ClassifierModel>  getAgnosticEnd2EndClassifierModel(@PathVariable("imageID") Long imageID) throws IM3WSException {
        try {
            Project project = getProject(imageID);
            NotationType notationType = project.getNotationType();
            ManuscriptType manuscriptType = project.getManuscriptType();
            Integer projectID = project.getId();
            Integer collectionID = project.getCollection().getId();

            return this.classifierClient.getModels(ClassifierModelTypes.eAgnosticEnd2End, collectionID, projectID, notationType.name(), manuscriptType.name());
        } catch (IM3WSException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot get classifier models", e);
            throw new IM3WSException("There was an error retrieving Agnostic End to end models, it is possible that the folder referenced does not exist in the classification server");
        }
    }

    @PostMapping(path = {"uploadmodel"})
    @Transactional
    public StringResponse uploadModel(UploadModel c_uploadModel) throws IM3WSException
    {
        System.out.println(c_uploadModel.geteModelFile());
        Path pathToFile = Paths.get(muretconfig.getFolder(), MURETConfiguration.MODELS_FOLDER);
        String fileName = fileStorageService.storeFile(pathToFile, c_uploadModel.geteModelFile());
        Path filePath = Paths.get(pathToFile.toString(), fileName);
        classifierClient.uploadModelZip(c_uploadModel, filePath);
        return new StringResponse("Received pal");
    }

}


