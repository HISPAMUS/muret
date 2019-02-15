package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.graphics.BoundingBox;
import es.ua.dlsi.im3.core.adt.graphics.BoundingBoxXY;
import es.ua.dlsi.im3.omr.classifiers.symbolrecognition.DLSymbolAndPositionClassifier;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class AgnosticRepresentationModel {
    private final MURETConfiguration muretConfiguration;

    @Autowired
    public AgnosticRepresentationModel(MURETConfiguration muretConfiguration) {
        this.muretConfiguration = muretConfiguration;
    }

    public AgnosticSymbol classifySymbolFromImageBoundingBox(Image image, int fromX, int fromY, int toX, int toY, String classifierName) throws IM3Exception {
        //TODO generalizar - coger el clasificador cargado - ¿si está el python en memoria tb.?

        boolean usePythonClassifiers = false;
        ////TODO
        Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "TO-DO HE DESACTIVADO LAS PETICIONES A PYTHON");
        if (!usePythonClassifiers) {
            return AgnosticSymbol.parseAgnosticString(AgnosticVersion.v2, "clef.C:L3"); // TODO - siempre devuelvo lo mismo
        } else {
            File localClassifierPath = new File(muretConfiguration.getPythonclassifiers(), "symbol-classification");

            // just execute test in drizo's computer :(
            if (!localClassifierPath.exists()) {
                throw new IM3Exception("Python classifier path not found: '" + localClassifierPath.getAbsolutePath() + "'");
            } else {
                DLSymbolAndPositionClassifier classifier = new DLSymbolAndPositionClassifier(localClassifierPath);
                BoundingBox boundingBox = new BoundingBoxXY(fromX, fromY, toX, toY);

                File muretProjectsFolder = new File(image.getProject().getPath()); // TODO estático
                File imagesFolder = new File(muretProjectsFolder, MURETConfiguration.MASTER_IMAGES);
                File imageFile = new File(imagesFolder, image.getFilename());
                if (!imageFile.exists()) {
                    throw new IM3Exception("Image to classify '" + imageFile + "' does not exist");
                }
                AgnosticSymbol agnosticSymbol = classifier.recognize(imageFile, boundingBox);
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "DL classifier returned {0}", agnosticSymbol);
                return agnosticSymbol;
            }
        }
    }
}
