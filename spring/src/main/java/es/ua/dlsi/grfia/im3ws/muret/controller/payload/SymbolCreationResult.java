package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.grfia.im3ws.muret.entity.Symbol;

import java.util.List;

/**
 * It contains a new agnosticSymbol inserted and the other possibilities
 */
public class SymbolCreationResult {
    Symbol agnosticSymbol;
    List<AgnosticSymbolTypeAndPosition> classifiedSymbols;

    public SymbolCreationResult(Symbol symbol, List<AgnosticSymbolTypeAndPosition> classifiedSymbols) {
        this.agnosticSymbol = symbol;
        this.classifiedSymbols = classifiedSymbols;
    }

    public Symbol getAgnosticSymbol() {
        return agnosticSymbol;
    }

    public List<AgnosticSymbolTypeAndPosition> getClassifiedSymbols() {
        return classifiedSymbols;
    }
}
