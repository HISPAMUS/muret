package es.ua.dlsi.grfia.im3ws.muret.model.trainingsets;

import es.ua.dlsi.grfia.im3ws.muret.model.ITrainingSetExporter;
import es.ua.dlsi.im3.core.IM3Exception;

import java.util.*;

/**
 * @author drizo
 */
public class TrainingSetsFactory {
    private static TrainingSetsFactory instance = null;

    private List<ITrainingSetExporter> trainingSetExporters;

    private TrainingSetsFactory() {
        this.trainingSetExporters = Arrays.asList(
                new ImagesExporter(0),
                new JSONTagging(1,true),
                new JSONTagging(2, false));

    }

    public final Collection<ITrainingSetExporter> getTrainingSetExporters() {
        return trainingSetExporters;
    }

    public ITrainingSetExporter getTrainingSetExporter(int index) throws IM3Exception {
        if (index < 0 || index >= trainingSetExporters.size()) {
            throw new IM3Exception("Cannot find training set exporter with index '" + index + "'");
        }
        return trainingSetExporters.get(index);
    }

    public static synchronized TrainingSetsFactory getInstance() {
        if (instance == null) {
            instance = new TrainingSetsFactory();
        }
        return instance;
    }
}

