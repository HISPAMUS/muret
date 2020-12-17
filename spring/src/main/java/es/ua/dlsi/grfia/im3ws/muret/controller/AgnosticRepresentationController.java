package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.CommentsBody;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.SymbolCreationFromBoundingBox;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.SymbolCreationFromStrokes;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.SymbolCreationResult;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticRepresentationModel;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.PageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
//!Important: no controller should throw any exception
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

    @Transactional
    @GetMapping(path = {"changeAgnosticSymbol/{symbolID}/{agnosticSymbolTypeString}/{positionInStaffString}"})
    public Symbol changeAgnosticSymbol(@PathVariable("symbolID") Long symbolID,
                                           @PathVariable("agnosticSymbolTypeString") String agnosticSymbolTypeString,
                                           @PathVariable("positionInStaffString") String positionInStaffString
    )  {
        try {
            return this.agnosticRepresentationModel.changeAgnosticSymbol(symbolID, agnosticSymbolTypeString, positionInStaffString);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this,"Cannot update symbol bounding box", e);

        }
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
    public Symbol symbolBoundingBoxUpdate(@RequestBody BoundingBox boundingBox)  {
        try {
            return this.agnosticRepresentationModel.symbolBoundingBoxUpdate(boundingBox);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot update symbol bounding box", e);

        }
    }

    @PutMapping(path = {"symbolCommentsUpdate"})
    public Symbol symbolCommentsUpdate(@RequestBody CommentsBody commentsBody) {
        try {
            Symbol symbol = getSymbol(commentsBody.getId());
            symbol.setComments(commentsBody.getComments());
            symbolRepository.save(symbol);
            return symbol;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot update comments", e);

        }
    }

    /**
     * @param symbolID
     * @return Deleted symbol ID
     * @throws IM3WSException
     */
    @DeleteMapping(path = {"deleteSymbol/{symbolID}"})
    public long deleteSymbol(@PathVariable("symbolID") long symbolID) {

        try {
            return this.agnosticRepresentationModel.deleteSymbol(symbolID);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this,"Cannot delete symbol", e);

        }
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
    public SymbolCreationResult createSymbolFromBoundingBox(@RequestBody SymbolCreationFromBoundingBox symbolCreationFromBoundingBox) {
        //TODO - poner el modelo correcto desde el frontend
        SymbolCreationResult result = null;
        try {
            result = this.agnosticRepresentationModel.createSymbol(symbolCreationFromBoundingBox.getModelID(), symbolCreationFromBoundingBox.getRegionID(), symbolCreationFromBoundingBox.getBoundingBox(),
                    symbolCreationFromBoundingBox.getAgnosticSymbolType(), symbolCreationFromBoundingBox.getPositionInStaff());
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot create symbol using a bounding box", e);

        }
        return result;
        //TODO ModelID
    }

    /**
     * @param symbolCreationFromStrokes
     * @return Created symbol
     * @throws IM3WSException
     */
    @PostMapping(path = {"createSymbolFromStrokes"})
    public SymbolCreationResult createSymbolFromStrokes(@RequestBody SymbolCreationFromStrokes symbolCreationFromStrokes) {
        try {
            return this.agnosticRepresentationModel.createSymbol(symbolCreationFromStrokes.getModelID(), symbolCreationFromStrokes.getRegionID(), symbolCreationFromStrokes.getPoints(),
                    symbolCreationFromStrokes.getAgnosticSymbolType(), symbolCreationFromStrokes.getPositionInStaff());
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot create symbol from strokes", e);

        }
        //TODO ModelID
    }

    @GetMapping(path = {"classifyRegionEndToEnd/{modelID}/{regionID}"})
    public List<Symbol> classifyRegionEndToEnd(@PathVariable(name="modelID") String modelID, @PathVariable(name="regionID") Long regionID) {
        try {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Classifying region end to end");
            Objects.requireNonNull(modelID, "modelID cannot be null");
            Objects.requireNonNull(regionID, "regionID cannot be null");

            return this.agnosticRepresentationModel.classifyRegionEndToEnd(modelID, regionID);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot classify end to end", e);
        }
    }

    @DeleteMapping(path = {"clearRegionSymbols/{regionID}"})
    public boolean clearRegionSymbols$(@PathVariable(name="regionID") Long regionID) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Clear region symbols");
        Objects.requireNonNull(regionID, "regionID cannot be null");

        try {
            return this.agnosticRepresentationModel.clearRegionSymbols(regionID);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot clear region symbols", e);

        }
    }
}
