package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.LinkedList;

public class Staff implements IStaff {
    private final LinkedList<IStaffSymbol> items;

    public Staff() {
        items = new LinkedList<>();
    }

    @Override
    public int getNumber() {
        return 0; //TODO
    }

    @Override
    public IStaffSymbol[] getStaffSymbols() {
        return items.toArray(new IStaffSymbol[items.size()]);
    }

    @Override
    public void addItem(IStaffSymbol symbol) {
        this.items.add(symbol);
    }


    @Override
    public IStaff[] getStaves() {
        return new IStaff[] {this};
    }
}
