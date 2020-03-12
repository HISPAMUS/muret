package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.ISymbol;
import es.ua.dlsi.grfia.moosicae.core.ISymbolInStaff;

public class SymbolInStaff extends StaffSymbol implements ISymbolInStaff {
    private ISymbol symbol;

    SymbolInStaff(ISymbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public ISymbol getSymbol() {
        return symbol;
    }

}
