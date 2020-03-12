package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.ISymbol;
import es.ua.dlsi.grfia.moosicae.core.IStaffElementOfSymbol;

public class StaffElementOfSymbol extends StaffElement implements IStaffElementOfSymbol {
    private ISymbol symbol;

    StaffElementOfSymbol(ISymbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public ISymbol getSymbol() {
        return symbol;
    }

}
