package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.AgnosticSymbolTypeAndPosition;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.SymbolCreationResult;
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
import java.util.List;
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

    class BBoxStrokes {
        CalcoStrokes calcoStrokes;
        BoundingBox boundingBox;

        public BBoxStrokes(es.ua.dlsi.grfia.im3ws.muret.controller.payload.Point[][] points) throws IM3WSException {
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            int npoints=0;
            calcoStrokes = new CalcoStrokes();
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

            boundingBox = new BoundingBox(minX-BOUNDING_BOX_TOLERANCE, minY-BOUNDING_BOX_TOLERANCE, maxX+BOUNDING_BOX_TOLERANCE, maxY+BOUNDING_BOX_TOLERANCE);
        }

        public CalcoStrokes getCalcoStrokes() {
            return calcoStrokes;
        }

        public BoundingBox getBoundingBox() {
            return boundingBox;
        }
    }

    @Transactional
    protected SymbolCreationResult createSymbol(long regionID, BoundingBox boundingBox, Strokes strokes, AgnosticSymbol agnosticSymbol) throws IM3WSException, IM3Exception {
        Region persistentRegion = getRegion(regionID);

        List<AgnosticSymbolTypeAndPosition> otherPossibilities = null;
        if (agnosticSymbol == null) { // if not provided, try to classify
            Image persistentImage = persistentRegion.getPage().getImage();
            long imageID = persistentImage.getId();
            Path imagePath = Paths.get(muretConfiguration.getFolder(), persistentImage.getProject().getPath(),
                    MURETConfiguration.MASTER_IMAGES, persistentImage.getFilename());

            otherPossibilities= symbolClassifierClient.classifyImage(imageID, imagePath, boundingBox);

            if (otherPossibilities != null && otherPossibilities.size() > 0) {
                AgnosticSymbolType agnosticSymbolType = AgnosticSymbolTypeFactory.parseString(otherPossibilities.get(0).getAgnosticSymbolType());
                PositionInStaff positionInStaff = PositionInStaff.parseString(otherPossibilities.get(0).getPositionInStaff());
                agnosticSymbol = new AgnosticSymbol(AgnosticVersion.v2, agnosticSymbolType, positionInStaff);
            }
        }

        if (agnosticSymbol != null) {
            Symbol symbol = new Symbol();
            symbol.setAgnosticSymbol(agnosticSymbol);
            boundingBox.adjustToFitInto(persistentRegion.getBoundingBox());
            symbol.setBoundingBox(boundingBox);
            symbol.setRegion(getRegion(regionID));
            Symbol persistentSymbol = symbolRepository.save(symbol);
            persistentRegion.getSymbols().add(persistentSymbol);
            //regionRepository.save(persistentRegion);

            SymbolCreationResult result = new SymbolCreationResult(persistentSymbol, otherPossibilities);
            return result;
        } else {
            return null;
        }
    }


    @Transactional
    protected SymbolCreationResult createSymbol(long regionID, BoundingBox boundingBox, Strokes strokes, String agnosticSymbolType, String positionInStaffStr) throws IM3WSException, IM3Exception {
        if (agnosticSymbolType == null || positionInStaffStr == null) {
            return createSymbol(regionID, boundingBox, strokes, null);
        } else {
            AgnosticSymbol agnosticSymbol = new AgnosticSymbol(AgnosticVersion.v2,
                    AgnosticSymbolTypeFactory.parseString(agnosticSymbolType),
                    PositionInStaff.parseString(positionInStaffStr));
            return createSymbol(regionID, boundingBox, strokes, agnosticSymbol);
        }
    }

    @Transactional
    public SymbolCreationResult createSymbol(long regionID, BoundingBox boundingBox, String agnosticSymbolType, String positionInStaffStr) throws IM3WSException, IM3Exception {
        if (agnosticSymbolType == null || positionInStaffStr == null) {
            return createSymbol(regionID, boundingBox, (Strokes)null, null);
        } else {
            AgnosticSymbol agnosticSymbol = new AgnosticSymbol(AgnosticVersion.v2,
                    AgnosticSymbolTypeFactory.parseString(agnosticSymbolType),
                    PositionInStaff.parseString(positionInStaffStr));
            return createSymbol(regionID, boundingBox, null, agnosticSymbol);
        }
    }


    @Transactional
    public SymbolCreationResult createSymbol(long regionID, es.ua.dlsi.grfia.im3ws.muret.controller.payload.Point[][] points, String agnosticSymbolType, String positionInStaffStr) throws IM3WSException, IM3Exception {
        BBoxStrokes bBoxStrokes = new BBoxStrokes(points);
        return createSymbol(regionID, bBoxStrokes.getBoundingBox(), bBoxStrokes.getCalcoStrokes(), agnosticSymbolType, positionInStaffStr);
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

    /*@Transactional
    public List<AgnosticSymbolTypeAndPosition> classifySymbol(long regionID, BoundingBox boundingBox) throws IM3WSException, IM3Exception {
        Region persistentRegion = getRegion(regionID);
        boundingBox.adjustToFitInto(persistentRegion.getBoundingBox());
        Image persistentImage = persistentRegion.getPage().getImage();

        long imageID = persistentImage.getId();
        Path imagePath = Paths.get(muretConfiguration.getFolder(), persistentImage.getProject().getPath(),
                MURETConfiguration.MASTER_IMAGES, persistentImage.getFilename());

        return symbolClassifierClient.classifyImage(imageID, imagePath, boundingBox);
    }

    @Transactional
    public List<AgnosticSymbolTypeAndPosition> classifySymbol(long regionID, es.ua.dlsi.grfia.im3ws.muret.controller.payload.Point[][] points) throws IM3WSException, IM3Exception {
        BBoxStrokes bBoxStrokes = new BBoxStrokes(points);
        return classifySymbol(regionID, bBoxStrokes.getBoundingBox());
    }*/
}
