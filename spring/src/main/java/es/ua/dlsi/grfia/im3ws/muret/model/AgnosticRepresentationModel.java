package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.PositionInStaff;
import es.ua.dlsi.im3.core.score.PositionsInStaff;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolTypeFactory;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class AgnosticRepresentationModel {
    private static final int BOUNDING_BOX_TOLERANCE = 10;
    // see agnostic-representation.component.ts
    private static final String AGNOSTIC_SYMBOL_TYPE_FROM_CLASSIFIER = "USE_SYMBOL_CLASSIFIER";
    private final RegionRepository regionRepository;
    private final SymbolRepository symbolRepository;
    private final SymbolClassifierClient symbolClassifierClient;
    private final MURETConfiguration muretConfiguration;


    @Autowired
    public AgnosticRepresentationModel(MURETConfiguration muretConfiguration, RegionRepository regionRepository, SymbolRepository symbolRepository) {
        this.muretConfiguration = muretConfiguration;
        this.regionRepository = regionRepository;
        this.symbolRepository = symbolRepository;
        this.symbolClassifierClient = new SymbolClassifierClient(muretConfiguration.getPythonclassifiers());

    }

    /*public AgnosticSymbol classifySymbolFromImageBoundingBox(Image image, int fromX, int fromY, int toX, int toY, String classifierName) throws IM3Exception {

        boolean usePythonClassifiers = false;
        Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "TO-DO HE DESACTIVADO LAS PETICIONES A PYTHON");
        if (!usePythonClassifiers) {
            return AgnosticSymbol.parseAgnosticString(AgnosticVersion.v2, "clef.C:L3");
        } else {
            File localClassifierPath = new File(muretConfiguration.getPythonclassifiers(), "symbol-classification");

            // just execute test in drizo's computer :(
            if (!localClassifierPath.exists()) {
                throw new IM3Exception("Python classifier path not found: '" + localClassifierPath.getAbsolutePath() + "'");
            } else {
                DLSymbolAndPositionClassifier classifier = new DLSymbolAndPositionClassifier(localClassifierPath);
                BoundingBox boundingBox = new BoundingBoxXY(fromX, fromY, toX, toY);

                File muretProjectsFolder = new File(image.getProject().getPath());
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
    }*/

    private Region getRegion(long regionID) throws IM3WSException {
        Optional<Region> persistentRegion = regionRepository.findById(regionID);
        if (!persistentRegion.isPresent()) {
            throw new IM3WSException("Cannot find region with ID=" + regionID);
        }
        return persistentRegion.get();
    }

    @Transactional
    protected Symbol createSymbol(long regionID, BoundingBox boundingBox, Strokes strokes, String agnosticSymbolType) throws IM3WSException, IM3Exception {
        Region persistentRegion = getRegion(regionID);

        boundingBox.adjustToFitInto(persistentRegion.getBoundingBox());
        Symbol symbol = new Symbol();
        symbol.setBoundingBox(boundingBox);
        symbol.setStrokes(strokes);
        symbol.setRegion(persistentRegion);


        AgnosticSymbol agnosticSymbol = null;

        Image persistentImage = persistentRegion.getPage().getImage();
        
        long imageID = persistentImage.getId();
        Path imagePath = Paths.get(muretConfiguration.getFolder(), persistentImage.getProject().getPath(), MURETConfiguration.MASTER_IMAGES, persistentImage.getFilename());

        try {
            agnosticSymbol = symbolClassifierClient.classifyImage(imageID, imagePath, boundingBox);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Error classifying symbol, using defaults", e);
            agnosticSymbol = AgnosticSymbol.parseAgnosticString(AgnosticVersion.v2, "clef.C:L3");
        }

        if (agnosticSymbolType != null && !agnosticSymbolType.equals(AGNOSTIC_SYMBOL_TYPE_FROM_CLASSIFIER)) {
            // if an agnostic type is provided, use it
            agnosticSymbol.changeAgnosticSymbolType(AgnosticSymbolTypeFactory.parseString(agnosticSymbolType));
        }

        symbol.setAgnosticSymbol(agnosticSymbol);
        symbol.setRegion(persistentRegion);
        Symbol persistentSymbol = symbolRepository.save(symbol);
        persistentRegion.getSymbols().add(persistentSymbol);
        //regionRepository.save(persistentRegion);
        return persistentSymbol;
    }

    @Transactional
    public Symbol createSymbol(long regionID, BoundingBox boundingBox, String agnosticSymbolType) throws IM3WSException, IM3Exception {
        return createSymbol(regionID, boundingBox, null, agnosticSymbolType);
    }

    @Transactional
    public Symbol createSymbol(long regionID, es.ua.dlsi.grfia.im3ws.muret.controller.payload.Point[][] points, String agnosticSymbolType) throws IM3WSException, IM3Exception {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int npoints=0;
        CalcoStrokes calcoStrokes = new CalcoStrokes();
        for (es.ua.dlsi.grfia.im3ws.muret.controller.payload.Point[] strokePoints: points) {
            CalcoStroke calcoStroke = new CalcoStroke();
            calcoStrokes.addStroke(calcoStroke);
            for (es.ua.dlsi.grfia.im3ws.muret.controller.payload.Point point: strokePoints) {
                calcoStroke.addPoint(new es.ua.dlsi.grfia.im3ws.muret.entity.Point(point.getTime(), point.getX(), point.getY()));

                minX = Math.min(minX, point.getX());
                minY = Math.min(minY, point.getY());
                maxX = Math.max(maxX, point.getX());
                maxY = Math.max(maxY, point.getY());

                npoints++;
            }
        }

        if (npoints < 2) {
            throw new IM3WSException("Cannot classify with just one point");
        }

        BoundingBox boundingBox = new BoundingBox(minX-BOUNDING_BOX_TOLERANCE, minY-BOUNDING_BOX_TOLERANCE, maxX+BOUNDING_BOX_TOLERANCE, maxY+BOUNDING_BOX_TOLERANCE);


        return createSymbol(regionID, boundingBox, calcoStrokes, agnosticSymbolType);
    }

    /**
     *
     * @param symbolID
     * @return Deleted symbol ID
     * @throws IM3WSException
     */
    @Transactional
    public long deleteSymbol(long symbolID) throws IM3WSException {
        Optional<Symbol> persistentSymbol = symbolRepository.findById(symbolID);
        if (!persistentSymbol.isPresent()) {
            throw new IM3WSException("Cannot find symbol with ID=" + symbolID);
        }

        Region persistentRegion = getRegion(persistentSymbol.get().getRegion().getId());
        persistentRegion.getSymbols().remove(persistentSymbol.get());
        return symbolID;
    }
}
