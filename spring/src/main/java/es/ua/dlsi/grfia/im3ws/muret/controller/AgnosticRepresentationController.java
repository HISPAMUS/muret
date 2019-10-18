package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.CommentsBody;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.SymbolCreationFromBoundingBox;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.SymbolCreationFromStrokes;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.SymbolCreationResult;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.ActionLogAgnosticModel;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticRepresentationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticSymbolFont;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticSymbolFontSingleton;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.PageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.PositionInStaff;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolTypeFactory;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
public class AgnosticRepresentationController extends MuRETBaseController {
    private final AgnosticRepresentationModel agnosticRepresentationModel;
    //private final ClassifierRepository classifierRepository;


    @Autowired
    public AgnosticRepresentationController(MURETConfiguration muretConfiguration, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository, AgnosticRepresentationModel agnosticRepresentationModel) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
        this.agnosticRepresentationModel = agnosticRepresentationModel;
    }


    // see JSONTagging.generateDictionary
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
            SVGSet result = new SVGSet(agnosticSymbolFont.getLayoutFont().getSVGFont().getAscent(),
                    agnosticSymbolFont.getLayoutFont().getSVGFont().getDescent(),
                    agnosticSymbolFont.getLayoutFont().getSVGFont().getUnitsPerEM(),
                    agnosticSymbolFont.getFullSVGSetPathd());
            return result;
        } catch (IM3Exception e) {
            throw new IM3WSException(e);
        }
    }

    @Transactional
    @GetMapping(path = {"changeAgnosticSymbol/{symbolID}/{agnosticSymbolTypeString}/{positionInStaffString}"})
    public Symbol changeAgnosticSymbol(@PathVariable("symbolID") Long symbolID,
                                           @PathVariable("agnosticSymbolTypeString") String agnosticSymbolTypeString,
                                           @PathVariable("positionInStaffString") String positionInStaffString
    ) throws IM3WSException, IM3Exception {
        return this.agnosticRepresentationModel.changeAgnosticSymbol(symbolID, agnosticSymbolTypeString, positionInStaffString);
    }

    /*@GetMapping(path = {"changeAgnosticPositionInStaff/{symbolID}/{difference}"})
    public Symbol changeAgnosticPositionInStaff(@PathVariable("symbolID") Long symbolID,
                                                @PathVariable("difference") int difference) throws IM3WSException, IM3Exception {
        Optional<Symbol> symbol = symbolRepository.findById(symbolID);
        if (!symbol.isPresent()) {
            throw new IM3WSException("Cannot find a symbol with id " + symbolID);
        }

        symbol.get().getAgnosticSymbol().setPositionInStaff(symbol.get().getAgnosticSymbol().getPositionInStaff().move(difference));
        //return symbolRepository.update(symbol.get());
        return symbolRepository.save(symbol.get());
    }*/

    @Transactional
    @PutMapping(path = {"symbolBoundingBoxUpdate"})
    public Symbol symbolBoundingBoxUpdate(@RequestBody BoundingBox boundingBox) throws IM3WSException {
        return this.agnosticRepresentationModel.symbolBoundingBoxUpdate(boundingBox);
    }

    @PutMapping(path = {"symbolCommentsUpdate"})
    public Symbol symbolCommentsUpdate(@RequestBody CommentsBody commentsBody) throws IM3WSException {
        Symbol symbol = getSymbol(commentsBody.getId());
        symbol.setComments(commentsBody.getComments());
        symbolRepository.save(symbol);
        return symbol;
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

    /*@PostMapping(path = {"classifySymbolFromBoundingBox"})
    public List<AgnosticSymbolTypeAndPosition> classifySymbolFromBoundingBox(@RequestBody SymbolCreationFromBoundingBox symbolCreationFromBoundingBox) throws IM3WSException, IM3Exception {
        return this.agnosticRepresentationModel.classifySymbol(symbolCreationFromBoundingBox.getRegionID(), symbolCreationFromBoundingBox.getBoundingBox());
    }
    @PostMapping(path = {"classifySymbolFromStrokes"})
    public List<AgnosticSymbolTypeAndPosition> classifySymbolFromStrokes(@RequestBody SymbolCreationFromStrokes symbolCreationFromStrokes) throws IM3WSException, IM3Exception {
        return this.agnosticRepresentationModel.classifySymbol(symbolCreationFromStrokes.getRegionID(), symbolCreationFromStrokes.getPoints());
    }*/

    /**
     * @param symbolCreationFromBoundingBox
     * @return Created symbol
     * @throws IM3WSException
     */
    @PostMapping(path = {"createSymbolFromBoundingBox"})
    public SymbolCreationResult createSymbolFromBoundingBox(@RequestBody SymbolCreationFromBoundingBox symbolCreationFromBoundingBox) throws IM3WSException, IM3Exception {
        SymbolCreationResult result = this.agnosticRepresentationModel.createSymbol("TODO", symbolCreationFromBoundingBox.getRegionID(), symbolCreationFromBoundingBox.getBoundingBox(),
                symbolCreationFromBoundingBox.getAgnosticSymbolType(), symbolCreationFromBoundingBox.getPositionInStaff());
        return result;
        //TODO ModelID
    }

    /**
     * @param symbolCreationFromStrokes
     * @return Created symbol
     * @throws IM3WSException
     */
    @PostMapping(path = {"createSymbolFromStrokes"})
    public SymbolCreationResult createSymbolFromStrokes(@RequestBody SymbolCreationFromStrokes symbolCreationFromStrokes) throws IM3WSException, IM3Exception {
        return this.agnosticRepresentationModel.createSymbol("zaragoza", symbolCreationFromStrokes.getRegionID(), symbolCreationFromStrokes.getPoints(),
                symbolCreationFromStrokes.getAgnosticSymbolType(), symbolCreationFromStrokes.getPositionInStaff());
        //TODO ModelID
    }

    @GetMapping(path = {"classifyRegionEndToEnd/{modelID}/{regionID}"})
    public List<Symbol> classifyRegionEndToEnd(@PathVariable(name="modelID") String modelID, @PathVariable(name="regionID") Long regionID) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Classifying region end to end");
        Objects.requireNonNull(modelID, "modelID cannot be null");
        Objects.requireNonNull(regionID, "regionID cannot be null");

        try {
            return this.agnosticRepresentationModel.classifyRegionEndToEnd(modelID, regionID);
        } catch (IM3Exception e) {
            throw new IM3WSException(e);
        }
    }

    @DeleteMapping(path = {"clearRegionSymbols/{regionID}"})
    public boolean clearRegionSymbols$(@PathVariable(name="regionID") Long regionID) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Clear region symbols");
        Objects.requireNonNull(regionID, "regionID cannot be null");

        return this.agnosticRepresentationModel.clearRegionSymbols(regionID);
    }
}
