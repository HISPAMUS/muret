package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.grfia.im3ws.muret.entity.Symbol;

import java.util.List;

/**
 * It contains a new agnosticSymbol inserted and the other possibilities
 */
public class SymbolCreationResult {
    Long pageID;
    Long regionID;
    Symbol agnosticSymbol;
    List<AgnosticSymbolTypeAndPosition> classifiedSymbols;

    public SymbolCreationResult(Long pageID, Long regionID, Symbol symbol, List<AgnosticSymbolTypeAndPosition> classifiedSymbols) {
        this.pageID = pageID;
        this.regionID = regionID;
        this.agnosticSymbol = symbol;
        this.classifiedSymbols = classifiedSymbols;
    }

    public Symbol getAgnosticSymbol() {
        return agnosticSymbol;
    }

    public List<AgnosticSymbolTypeAndPosition> getClassifiedSymbols() {
        return classifiedSymbols;
    }

    public Long getPageID() {
        return pageID;
    }

    public Long getRegionID() {
        return regionID;
    }
}
