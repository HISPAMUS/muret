package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.PostStrokes;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticRepresentationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticSymbolFont;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticSymbolFontSingleton;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.PositionInStaff;
import es.ua.dlsi.im3.core.score.layout.LayoutConstants;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolTypeFactory;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
@RequestMapping("agnostic")
@RestController
public class AgnosticRepresentationController {
    private final RegionRepository regionRepository;
    private final SymbolRepository symbolRepository;
    private final AgnosticRepresentationModel agnosticRepresentationModel;
    //private final ClassifierRepository classifierRepository;

    @Autowired
    public AgnosticRepresentationController(
            //ClassifierRepository classifierRepository,
            AgnosticRepresentationModel agnosticRepresentationModel,
            SymbolRepository symbolRepository,
            RegionRepository regionRepository) {
        //this.classifierRepository = classifierRepository;
        this.agnosticRepresentationModel = agnosticRepresentationModel;
        this.symbolRepository = symbolRepository;
        this.regionRepository = regionRepository;
    }

    /**
     *
     * @param notationType Mensural, modern
     * @param manuscriptType Handwritten, printed
     * @return Map<symbolType, svg>
     * @throws IM3WSException On SVG constructrion
     */
    /*@GetMapping(path = {"svgset"})
    public SVGSet getAgnosticSymbolSVGSet(@RequestParam(name="notationType") NotationType notationType, @RequestParam(name="manuscriptType") ManuscriptType manuscriptType) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting AgnosticSymbolSVGSet");
        Objects.requireNonNull(notationType, "notationType cannot be null");
        Objects.requireNonNull(manuscriptType, "manuscriptType cannot be null");
        AgnosticSymbolFont agnosticSymbolFont = AgnosticSymbolFontSingleton.getInstance().getLayoutFont(notationType, manuscriptType);

        return new SVGSet(agnosticSymbolFont.getLayoutFont().getScaleX(),
                agnosticSymbolFont.getLayoutFont().getScaleY(),
                LayoutConstants.EM,
                agnosticSymbolFont.getFullSVGSetPathd());
    }*/

    /*@GetMapping(path = {"createSymbolFromBoundingBox/{regionID}/{fromX}/{fromY}/{toX}/{toY}"})
    public Symbol createSymbolFromBoundingBox(@PathVariable("regionID") Long regionID,
                                              @PathVariable("fromX") Double fromX,
                                              @PathVariable("fromY") Double fromY,
                                              @PathVariable("toX") Double toX,
                                              @PathVariable("toY") Double toY) throws IM3WSException, IM3Exception {
        Optional<Region> region = regionRepository.findById(regionID);
        if (!region.isPresent()) {
            throw new IM3WSException("Cannot find a region with id " + regionID);
        }

        AgnosticSymbol agnosticSymbol = agnosticRepresentationModel.classifySymbolFromImageBoundingBox(region.get().getPage().getImage(),
                fromX.intValue(), fromY.intValue(), toX.intValue(), toY.intValue(), "TO-DO"); //TODO

        Logger.getLogger(this.getClass().getName()).severe("TO-DO CLASSIFIER"); //TODO Urgent

        Symbol symbol = new Symbol(region.get(), agnosticSymbol,
                new BoundingBox(fromX.intValue(), fromY.intValue(), toX.intValue(), toY.intValue()),
                null, null);

        //return symbolRepository.create(symbol);
        return symbolRepository.save(symbol);
    }*/

    //TODO Generalizar a cualquier tipo de strokes
    /*@RequestMapping(value="/createSymbolFromStrokes", method= RequestMethod.POST)
    @ResponseBody
    public Symbol createSymbol(@RequestBody PostStrokes requestObject) throws IM3WSException, IM3Exception {
        Optional<Region> region = regionRepository.findById(requestObject.getRegionID());
        if (!region.isPresent()) {
            throw new IM3WSException("Cannot find a region with id " + requestObject.getRegionID());
        }

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int npoints=0;
        CalcoStrokes calcoStrokes = new CalcoStrokes();
        for (es.ua.dlsi.grfia.im3ws.muret.controller.payload.Point[] strokePoints: requestObject.getPoints()) {
            CalcoStroke calcoStroke = new CalcoStroke();
            calcoStrokes.addStroke(calcoStroke);
            for (es.ua.dlsi.grfia.im3ws.muret.controller.payload.Point point: strokePoints) {
                calcoStroke.addPoint(new es.ua.dlsi.grfia.im3ws.muret.entity.Point(point.getTimestamp(), point.getX(), point.getY()));

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

        BoundingBox boundingBox = new BoundingBox(minX, minY, maxX, maxY);

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Bounding box from strokes {0}", boundingBox);
        //TODO Que busque (si está seleccionado) también en el clasificador por strokes

        AgnosticSymbol agnosticSymbol = agnosticRepresentationModel.classifySymbolFromImageBoundingBox(region.get().getPage().getImage(),
                minX, minY, maxX, maxY, "TO-DO"); //TODO

        Logger.getLogger(this.getClass().getName()).severe("TO-DO CLASSIFIER"); //TODO Urgent

        Symbol symbol = new Symbol(region.get(), agnosticSymbol,
                boundingBox,null, calcoStrokes);

        //return symbolRepository.create(symbol);
        return symbolRepository.save(symbol);
    }*/

    // with SymbolController --> repository --> delete it does not work
    /*@GetMapping(path = {"removeSymbol/{regionID}/{symbolID}"})
    public boolean removeSymbol(@PathVariable("regionID") Long regionID,
                                @PathVariable("symbolID") Long symbolID) throws IM3WSException {
        Optional<Region> region = regionRepository.findById(regionID);
        if (!region.isPresent()) {
            throw new IM3WSException("Cannot find a region with id " + regionID);
        }

        // the number of symbols is tiny
        for (Symbol symbol: region.get().getSymbols()) {
            if (symbol.getId().equals(symbolID)) {
                region.get().getSymbols().remove(symbol);
                //regionRepository.update(region.get()); // it removes the symbol
                regionRepository.save(region.get()); // it removes the symbol
                return true;
            }
        }

        throw new IM3WSException("Cannot find a symbol in region " + regionID + " with id " + symbolID);
    }*/

    /*@GetMapping(path = {"/region/{id}"})
    public List<Symbol> findByRegionID(@PathVariable(name="id") Long regionID) throws IM3WSException {
        // TODO This could be improved using a native query - this one makes two sql queries
        Optional<Region> region =  regionRepository.findById(regionID);
        if (!region.isPresent()) {
            throw new IM3WSException("Cannot find a region with ID = " + regionID);
        }

        return region.get().getSymbols();
    }*/

    /*@GetMapping(path = {"changeAgnosticSymbolType/{symbolID}/{agnosticSymbolTypeString}"})
    public Symbol changeAgnosticSymbolType(@PathVariable("symbolID") Long symbolID,
                                           @PathVariable("agnosticSymbolTypeString") String agnosticSymbolTypeString) throws IM3WSException, IM3Exception {
        Optional<Symbol> symbol = symbolRepository.findById(symbolID);
        if (!symbol.isPresent()) {
            throw new IM3WSException("Cannot find a symbol with id " + symbolID);
        }

        AgnosticSymbolType agnosticSymbolType = AgnosticSymbolTypeFactory.parseString(agnosticSymbolTypeString);
        symbol.get().setAgnosticSymbol(new AgnosticSymbol(AgnosticVersion.v2, agnosticSymbolType, symbol.get().getAgnosticSymbol().getPositionInStaff()));
        //return symbolRepository.update(symbol.get());
        return symbolRepository.save(symbol.get());
    }*/

    /*@GetMapping(path = {"changeAgnosticPositionInStaff/{symbolID}/{positionInStaffString}"})
    public Symbol changeAgnosticPositionInStaff(@PathVariable("symbolID") Long symbolID,
                                                @PathVariable("positionInStaffString") String positionInStaffString) throws IM3WSException, IM3Exception {
        Optional<Symbol> symbol = symbolRepository.findById(symbolID);
        if (!symbol.isPresent()) {
            throw new IM3WSException("Cannot find a symbol with id " + symbolID);
        }

        PositionInStaff positionInStaff = PositionInStaff.parseString(positionInStaffString);
        symbol.get().getAgnosticSymbol().setPositionInStaff(positionInStaff);
        //return symbolRepository.update(symbol.get());
        return symbolRepository.save(symbol.get());
    }*/

    /**
     *
     * @param symbolID Symbol ID
     * @param upOrDown up | down
     * @return .
     * @throws IM3WSException .
     */
    /*@GetMapping(path = {"changeAgnosticPositionInStaffUpOrDown/{symbolID}/{upOrDown}"})
    public Symbol changeAgnosticPositionInStaffUpOrDown(@PathVariable("symbolID") Long symbolID,
                                                        @PathVariable("upOrDown") String upOrDown) throws IM3WSException {
        Optional<Symbol> symbol = symbolRepository.findById(symbolID);
        if (!symbol.isPresent()) {
            throw new IM3WSException("Cannot find a symbol with id " + symbolID);
        }

        PositionInStaff positionInStaff = symbol.get().getAgnosticSymbol().getPositionInStaff();
        PositionInStaff newPositionInStaff;
        if (upOrDown.equals("up")) {
            newPositionInStaff = positionInStaff.move(1);
        } else if (upOrDown.equals("down")) {
            newPositionInStaff = positionInStaff.move(-1);
        } else {
            throw new IM3WSException("Invalid parameter 'upOrDown', it should be 'up' or 'down', and it is '" + upOrDown + "'");
        }

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Moving from {0} to {1}", new Object[]{positionInStaff, newPositionInStaff});
        symbol.get().getAgnosticSymbol().setPositionInStaff(newPositionInStaff);
        //return symbolRepository.update(symbol.get());
        return symbolRepository.save(symbol.get());
    }*/

}
