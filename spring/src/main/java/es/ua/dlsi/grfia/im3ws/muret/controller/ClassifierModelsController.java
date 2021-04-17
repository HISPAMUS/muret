package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.controller.StringResponse;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.ClassifierModel;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.ClassifierModelTypes;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.UploadModel;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.entity.ManuscriptType;
import es.ua.dlsi.grfia.im3ws.muret.model.ClassifierClient;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.service.FileStorageService;
import es.ua.dlsi.im3.core.score.NotationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
// !!! Important: no controller should throw any exception

/**
 * @author drizo
 */
@RequestMapping("classifierModels")
@RestController
public class ClassifierModelsController {
    public static final String AGNOSTIC2SEMANTIC_TRANSDUCER = "a2s_transducer";
    public static final String MANUALSYMBOL_CLASSIFIER = "symbol_manual";
    @Autowired
    private final ImageRepository imageRepository;

    private final ClassifierClient classifierClient;


    private final FileStorageService fileStorageService;
    private final MURETConfiguration muretconfig;

    @Autowired
    public ClassifierModelsController(MURETConfiguration muretConfiguration, ImageRepository imageRepository, FileStorageService fileStorageService, MURETConfiguration config) {
        classifierClient = new ClassifierClient(muretConfiguration.getPythonclassifiers());
        this.imageRepository = imageRepository;
        this.fileStorageService = fileStorageService;
        this.muretconfig = config;
    }

    /*@GetMapping(path = {"symbols/{collectionID}/{documentID}/{notationType}/{manuscriptType}"})
    public List<ClassifierModel> getSymbolClassifierModels(@PathVariable("collectionID") Long collectionID,
                                                           @PathVariable("documentID") Long documentID,
                                                           @PathVariable("notationType") String notationType,
                                                           @PathVariable("manuscriptType") String manuscriptType
    ) throws IM3WSException {
        try {
            return this.classifierClient.getModels(ClassifierModelTypes.eAgnosticSymbols, collectionID, documentID, notationType, manuscriptType);
        } catch (IM3WSException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot get classifier models", e);
            throw e;
        }
    }

    @GetMapping(path = {"agnosticEnd2End/{collectionID}/{documentID}/{notationType}/{manuscriptType}"})
    public List<ClassifierModel>  getAgnosticEnd2EndClassifierModel(@PathVariable("collectionID") Long collectionID,
                                            @PathVariable("documentID") Long documentID,
                                            @PathVariable("notationType") String notationType,
                                            @PathVariable("manuscriptType") String manuscriptType
    ) throws IM3WSException {
        try {
            return this.classifierClient.getModels(ClassifierModelTypes.eAgnosticEnd2End, collectionID, documentID, notationType, manuscriptType);
        } catch (IM3WSException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot get classifier models", e);
            throw new IM3WSException("There was an error retrieving Agnostic End to end models, it is possible that the folder referenced does not exist in the classification server");
        }
    }*/

    private Document getDocument(Long imageID) throws IM3WSException {
        Optional<Image> image = imageRepository.findById(imageID);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find image with ID " + imageID);
        }

        Document document = image.get().computeDocument();
        return document;
    }

    @GetMapping(path={"models/{imageID}"})
    @Transactional(readOnly = true)
    public List<ClassifierModel> getModels(@PathVariable("imageID") Long imageID) {
        ArrayList<ClassifierModel> result = new ArrayList<>();
        result.addAll(requestModels(ClassifierModelTypes.eDocumentAnalysis, imageID));

        ClassifierModel manualSymbolClassifier = new ClassifierModel();
        manualSymbolClassifier.setId(MANUALSYMBOL_CLASSIFIER);
        manualSymbolClassifier.setClassifier_type(ClassifierModelTypes.eAgnosticSymbols);
        manualSymbolClassifier.setLast_train(new Date(0)); // very old
        manualSymbolClassifier.setName("Manual");
        result.add(manualSymbolClassifier);
        result.addAll(requestModels(ClassifierModelTypes.eAgnosticSymbols, imageID));

        result.addAll(requestModels(ClassifierModelTypes.eAgnosticEnd2End, imageID));
        result.addAll(requestModels(ClassifierModelTypes.eSemanticEnd2End, imageID));

        ClassifierModel agnostic2SemanticTransducer = new ClassifierModel();
        agnostic2SemanticTransducer.setId(AGNOSTIC2SEMANTIC_TRANSDUCER);
        agnostic2SemanticTransducer.setClassifier_type(ClassifierModelTypes.eAgnostic2SemanticTranslator);
        agnostic2SemanticTransducer.setLast_train(new Date()); // very new
        agnostic2SemanticTransducer.setName("Agnostic to semantic transducer");
        result.add(agnostic2SemanticTransducer);
        List<ClassifierModel> a2sNeural = requestModels(ClassifierModelTypes.eAgnostic2SemanticTranslator, imageID);
        for (ClassifierModel n: a2sNeural) {
            n.setName(n.getName() + " (it looses agnostic ids)");
        }
        result.addAll(a2sNeural);


        return result;
    }

    @Transactional(readOnly = true)
    public List<ClassifierModel> requestModels(ClassifierModelTypes classifierType, Long imageID)
    {
        try {
            Document document = getDocument(imageID);
            if (document.getNotationType() == null) {
                throw new IM3WSException("The document has not a notation type");
            }
            NotationType notationType = document.getNotationType();
            ManuscriptType manuscriptType = document.getManuscriptType();
            Integer documentID = document.getId();
            Integer collectionID = document.getCollection().getId();
            return this.classifierClient.getModels(classifierType, collectionID, documentID, notationType.name(), manuscriptType.name());
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "There was an error retrieving Agnostic End to end models, it is possible that the folder referenced does not exist in the classification server: " + e.getMessage(), e);
        }
    }


    // revisado hasta aquí - ver? @Transactional(readOnly = true)


    @GetMapping(path = {"symbols/{imageID}"})
    @Transactional
    public List<ClassifierModel> getSymbolClassifierModels(@PathVariable("imageID") Long imageID) {
        return requestModels(ClassifierModelTypes.eAgnosticSymbols, imageID);
    }

    @GetMapping(path = {"agnosticEnd2End/{imageID}"})
    @Transactional
    public List<ClassifierModel>  getAgnosticEnd2EndClassifierModel(@PathVariable("imageID") Long imageID) {
        return requestModels(ClassifierModelTypes.eAgnosticEnd2End, imageID);
    }

    @GetMapping(path={"translator/{imageID}"})
    @Transactional
    public List<ClassifierModel> getTranslationClassifierModels(@PathVariable("imageID") Long imageID) {
        return requestModels(ClassifierModelTypes.eAgnostic2SemanticTranslator, imageID);
    }

    @PostMapping(path = {"uploadmodel"})
    @Transactional
    public StringResponse uploadModel(UploadModel c_uploadModel)  {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Uploading model {0}", c_uploadModel.geteModelFile());
        Path pathToFile = Paths.get(muretconfig.getFolder(), MURETConfiguration.MODELS_FOLDER);
        String fileName = fileStorageService.storeFile(pathToFile, c_uploadModel.geteModelFile());
        Path filePath = Paths.get(pathToFile.toString(), fileName);
        try {
            classifierClient.uploadModelZip(c_uploadModel, filePath);
            return new StringResponse("Received pal");
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot upload zipped model", e);

        }

    }

}


