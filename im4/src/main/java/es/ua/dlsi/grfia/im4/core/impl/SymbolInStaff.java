package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.ISymbol;
import es.ua.dlsi.grfia.im4.core.ISymbolInStaff;

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
