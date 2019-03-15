package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.SymbolCreationFromBoundingBox;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.SymbolCreationFromStrokes;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticRepresentationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticSymbolFont;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticSymbolFontSingleton;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolTypeFactory;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(path = {"svgset"})
    public SVGSet getAgnosticSymbolSVGSet(@RequestParam(name="notationType") NotationType notationType, @RequestParam(name="manuscriptType") ManuscriptType manuscriptType) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting AgnosticSymbolSVGSet");
        Objects.requireNonNull(notationType, "notationType cannot be null");
        Objects.requireNonNull(manuscriptType, "manuscriptType cannot be null");
        AgnosticSymbolFont agnosticSymbolFont = AgnosticSymbolFontSingleton.getInstance().getLayoutFont(notationType, manuscriptType);

        try {
            return new SVGSet(agnosticSymbolFont.getLayoutFont().getSVGFont().getAscent(),
                    agnosticSymbolFont.getLayoutFont().getSVGFont().getDescent(),
                    agnosticSymbolFont.getLayoutFont().getSVGFont().getUnitsPerEM(),
                    agnosticSymbolFont.getFullSVGSetPathd());
        } catch (IM3Exception e) {
            throw new IM3WSException(e);
        }
    }

    @GetMapping(path = {"changeAgnosticSymbolType/{symbolID}/{agnosticSymbolTypeString}"})
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
    }

    @GetMapping(path = {"changeAgnosticPositionInStaff/{symbolID}/{difference}"})
    public Symbol changeAgnosticPositionInStaff(@PathVariable("symbolID") Long symbolID,
                                                @PathVariable("difference") int difference) throws IM3WSException, IM3Exception {
        Optional<Symbol> symbol = symbolRepository.findById(symbolID);
        if (!symbol.isPresent()) {
            throw new IM3WSException("Cannot find a symbol with id " + symbolID);
        }

        symbol.get().getAgnosticSymbol().setPositionInStaff(symbol.get().getAgnosticSymbol().getPositionInStaff().move(difference));
        //return symbolRepository.update(symbol.get());
        return symbolRepository.save(symbol.get());
    }


    /**
     * @param symbolCreationFromBoundingBox
     * @return Created symbol
     * @throws IM3WSException
     */
    @PostMapping(path = {"createSymbolFromBoundingBox"})
    public Symbol createSymbolFromBoundingBox(@RequestBody SymbolCreationFromBoundingBox symbolCreationFromBoundingBox) throws IM3WSException, IM3Exception {
        return this.agnosticRepresentationModel.createSymbol(symbolCreationFromBoundingBox.getRegionID(), symbolCreationFromBoundingBox.getBoundingBox(), symbolCreationFromBoundingBox.getAgnosticSymbolType());
    }

    /**
     * @param symbolCreationFromStrokes
     * @return Created symbol
     * @throws IM3WSException
     */
    @PostMapping(path = {"createSymbolFromStrokes"})
    public Symbol createSymbolFromStrokes(@RequestBody SymbolCreationFromStrokes symbolCreationFromStrokes) throws IM3WSException, IM3Exception {
        return this.agnosticRepresentationModel.createSymbol(symbolCreationFromStrokes.getRegionID(), symbolCreationFromStrokes.getPoints(), symbolCreationFromStrokes.getAgnosticSymbolType());
    }

    /**
     * @param symbolID
     * @return Deleted symbol ID
     * @throws IM3WSException
     */
    @DeleteMapping(path = {"deleteSymbol/{symbolID}"})
    public long deleteSymbol(@PathVariable("symbolID") long symbolID) throws IM3WSException {
        return this.agnosticRepresentationModel.deleteSymbol(symbolID);
    }
}
