package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.ISymbol;
import es.ua.dlsi.grfia.moosicae.core.IStaffElementOfSymbol;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class StaffElementOfSymbol extends StaffElement implements IStaffElementOfSymbol {
    private ISymbol symbol;

    StaffElementOfSymbol(ISymbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public ISymbol getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StaffElementOfSymbol)) return false;

        StaffElementOfSymbol that = (StaffElementOfSymbol) o;

        return symbol.equals(that.symbol);
    }

    @Override
    public int hashCode() {
        return symbol.hashCode();
    }

    @Override
    public String toString() {
        return "StaffElementOfSymbol{" +
                "symbol=" + symbol +
                "} " + super.toString();
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        this.symbol.export(exportVisitor, inputOutput);
    }
}
