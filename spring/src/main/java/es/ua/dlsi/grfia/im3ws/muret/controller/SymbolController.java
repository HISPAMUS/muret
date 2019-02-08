package es.ua.dlsi.grfia.im3ws.muret.controller;


import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.controller.CRUDController;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.entity.Symbol;
import es.ua.dlsi.grfia.im3ws.muret.service.RegionService;
import es.ua.dlsi.grfia.im3ws.muret.service.SymbolService;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.PositionInStaff;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolTypeFactory;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
@RequestMapping("/muretapi/symbol")
@RestController
public class SymbolController extends CRUDController<Symbol, Long, SymbolService> {
    @Autowired
    SymbolService symbolService;
    @Autowired
    RegionService regionService;

    @Override
    protected SymbolService initService() {
        return symbolService;
    }

    @GetMapping(path = {"/region/{id}"})
    public List<Symbol> findByRegionID(@PathVariable(name="id") Long regionID) throws IM3WSException {
        // TODO This could be improved using a native query - this one makes two sql queries
        Optional<Region> region =  regionService.findById(regionID);
        if (!region.isPresent()) {
            throw new IM3WSException("Cannot find a region with ID = " + regionID);
        }

        return region.get().getSymbols();
    }

    @GetMapping(path = {"changeAgnosticSymbolType/{symbolID}/{agnosticSymbolTypeString}"})
    public Symbol changeAgnosticSymbolType(@PathVariable("symbolID") Long symbolID,
                               @PathVariable("agnosticSymbolTypeString") String agnosticSymbolTypeString) throws IM3WSException, IM3Exception {
        Optional<Symbol> symbol = symbolService.findById(symbolID);
        if (!symbol.isPresent()) {
            throw new IM3WSException("Cannot find a symbol with id " + symbolID);
        }

        AgnosticSymbolType agnosticSymbolType = AgnosticSymbolTypeFactory.parseString(agnosticSymbolTypeString);
        symbol.get().setAgnosticSymbol(new AgnosticSymbol(AgnosticVersion.v2, agnosticSymbolType, symbol.get().getAgnosticSymbol().getPositionInStaff()));
        return symbolService.update(symbol.get());
    }

    @GetMapping(path = {"changeAgnosticPositionInStaff/{symbolID}/{positionInStaffString}"})
    public Symbol changeAgnosticPositionInStaff(@PathVariable("symbolID") Long symbolID,
                                           @PathVariable("positionInStaffString") String positionInStaffString) throws IM3WSException, IM3Exception {
        Optional<Symbol> symbol = symbolService.findById(symbolID);
        if (!symbol.isPresent()) {
            throw new IM3WSException("Cannot find a symbol with id " + symbolID);
        }

        PositionInStaff positionInStaff = PositionInStaff.parseString(positionInStaffString);
        symbol.get().getAgnosticSymbol().setPositionInStaff(positionInStaff);
        return symbolService.update(symbol.get());
    }

    /**
     *
     * @param symbolID
     * @param upOrDown up | down
     * @return
     * @throws IM3WSException
     * @throws IM3Exception
     */
    @GetMapping(path = {"changeAgnosticPositionInStaffUpOrDown/{symbolID}/{upOrDown}"})
    public Symbol changeAgnosticPositionInStaffUpOrDown(@PathVariable("symbolID") Long symbolID,
                                                @PathVariable("upOrDown") String upOrDown) throws IM3WSException {
        Optional<Symbol> symbol = symbolService.findById(symbolID);
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
        return symbolService.update(symbol.get());
    }
}
