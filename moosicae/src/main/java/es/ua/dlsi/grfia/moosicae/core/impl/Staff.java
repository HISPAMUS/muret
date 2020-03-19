package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.LinkedList;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Staff implements IStaff {
    private final LinkedList<ISymbol> items;

    public Staff() {
        items = new LinkedList<>();
    }

    @Override
    public int getNumber() {
        return 0; //TODO
    }

    @Override
    public ISymbol[] getStaffSymbols() {
        return items.toArray(new ISymbol[items.size()]);
    }

    @Override
    public void addLayoutElement(IStaffLayoutElement staffLayoutElement) {
        this.items.add(staffLayoutElement);
    }

    @Override
    public void put(ISymbol symbol) {
        this.items.add(symbol);
    }

    @Override
    public void remove(ISymbol symbol) {
        this.items.remove(symbol);
    }


    @Override
    public IStaff[] getStaves() {
        return new IStaff[] {this};
    }
}
