package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.LinkedList;

public class Staff implements IStaff {
    private final LinkedList<IStaffElement> items;

    public Staff() {
        items = new LinkedList<>();
    }

    @Override
    public int getNumber() {
        return 0; //TODO
    }

    @Override
    public IStaffElement[] getStaffSymbols() {
        return items.toArray(new IStaffElement[items.size()]);
    }

    @Override
    public void addLayoutElement(IStaffLayoutElement staffLayoutElement) {
        this.items.add(staffLayoutElement);
    }

    @Override
    public IStaffElementOfSymbol put(ISymbol symbol) {
        IStaffElementOfSymbol wrapper = new StaffElementOfSymbol(symbol);
        this.items.add(wrapper);
        return wrapper;
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
