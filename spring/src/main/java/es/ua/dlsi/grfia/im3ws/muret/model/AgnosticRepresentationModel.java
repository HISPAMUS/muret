package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.PositionsInStaff;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolTypeFactory;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class AgnosticRepresentationModel {
    private static final int BOUNDING_BOX_TOLERANCE = 10;
    private final MURETConfiguration muretConfiguration;
    private final RegionRepository regionRepository;
    private final SymbolRepository symbolRepository;

    @Autowired
    public AgnosticRepresentationModel(MURETConfiguration muretConfiguration, RegionRepository regionRepository, SymbolRepository symbolRepository) {
        this.muretConfiguration = muretConfiguration;
        this.regionRepository = regionRepository;
        this.symbolRepository = symbolRepository;
    }

    /*public AgnosticSymbol classifySymbolFromImageBoundingBox(Image image, int fromX, int fromY, int toX, int toY, String classifierName) throws IM3Exception {
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
        AgnosticSymbol agnosticSymbol = new AgnosticSymbol(AgnosticVersion.v2,
                AgnosticSymbolTypeFactory.parseString(agnosticSymbolType),
                PositionsInStaff.LINE_3);
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
