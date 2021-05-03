package es.ua.dlsi.grfia.im3ws.muret.model.trainingsets;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.model.ITrainingSetExporter;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentModel;
import es.ua.dlsi.im3.core.IM3Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import java.io.File;
import java.util.*;

/**
 * @author drizo
 */
@Component
public class TrainingSetsFactory {
    //private static TrainingSetsFactory instance = null;

    private List<ITrainingSetExporter> trainingSetExporters;

    @Autowired
    public TrainingSetsFactory(DocumentModel documentModel, MURETConfiguration muretConfiguration) {
        this.trainingSetExporters = Arrays.asList(
                new ImagesExporter(documentModel, 0, false),
                new ImagesExporter(documentModel, 1, true),
                new JSONTagging(2,true, muretConfiguration),
                new JSONTagging(3, false, muretConfiguration),
                new AgnosticSemanticTrainingSetExporter(4, documentModel)
                /*new AgnosticSymbolImagesTextFile(4, false, false), // just used in command line (see ExportTrainingSet)
                new AgnosticSymbolImagesTextFile(5, false, true),
                new AgnosticSymbolImagesTextFile(6, true, false),
                new AgnosticSymbolImagesTextFile(7, true, true)*/
                );

    }

    public final List<ITrainingSetExporter> getTrainingSetExporters() {
        return trainingSetExporters;
    }

    public ITrainingSetExporter getTrainingSetExporter(int index) throws IM3Exception {
        if (index < 0 || index >= trainingSetExporters.size()) {
            throw new IM3Exception("Cannot find training set exporter with index '" + index + "'");
        }
        return trainingSetExporters.get(index);
    }

    /*public static synchronized TrainingSetsFactory getInstance(EntityManagerFactory entityManagerFactory) {
        if (instance == null) {
            instance = new TrainingSetsFactory();
        }
        return instance;
    }*/
}

