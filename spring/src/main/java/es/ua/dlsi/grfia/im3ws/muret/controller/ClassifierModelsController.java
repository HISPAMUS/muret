package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.controller.StringResponse;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.AgnosticEncodingJSON;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.AgnosticSymbolTypeAndPosition;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.ClassifierModel;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.ClassifierModelTypes;
import es.ua.dlsi.grfia.im3ws.muret.entity.Symbol;
import es.ua.dlsi.grfia.im3ws.muret.model.ClassifierClient;
import es.ua.dlsi.grfia.im3ws.muret.model.NotationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.TranslationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.PositionInStaff;
import es.ua.dlsi.im3.omr.encoding.agnostic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
@RequestMapping("classifierModels")
@RestController
public class ClassifierModelsController {
    private final ClassifierClient classifierClient;

    @Autowired
    public ClassifierModelsController(MURETConfiguration muretConfiguration) {
        classifierClient = new ClassifierClient(muretConfiguration.getPythonclassifiers());
    }

    @GetMapping(path = {"symbols/{collectionID}/{projectID}/{notationType}/{manuscriptType}"})
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
    }

}


