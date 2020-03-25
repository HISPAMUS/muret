package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IStaffLineCount;

import javax.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Staff extends CoreObject implements IStaff {
    @NotNull
    IStaffLineCount staffLineCount;

    @NotNull
    private final List<ICoreItem> items;

    public Staff(IId id, @NotNull IStaffLineCount staffLineCount) {
        super(id);
        this.staffLineCount = staffLineCount;
        items = new LinkedList<>();
    }

    public Staff(IId id, IStaffLineCount staffLineCount, ICoreItem[] items) {
        super(id);
        this.staffLineCount = staffLineCount;
        this.items = Arrays.asList(items);
    }

    @Override
    public ICoreItem[] getStaffSymbols() {
        return items.toArray(new ICoreItem[items.size()]);
    }

    @Override
    public IStaffLineCount getStaffLineCount() {
        return staffLineCount;
    }

    @Override
    public void addLayoutElement(IStaffLayoutElement staffLayoutElement) {
        this.items.add(staffLayoutElement);
    }

    @Override
    public void put(ICoreItem symbol) {
        this.items.add(symbol);
    }

    @Override
    public void remove(ICoreItem symbol) {
        this.items.remove(symbol);
    }


    @Override
    public IStaff[] getStaves() {
        return new IStaff[] {this};
    }

    @Override
    public Staff clone() {
        Staff staff = new Staff(null, staffLineCount);
        for (ICoreItem symbol: items) {
            items.add(symbol); // do not clone, it's an aggregation
        }
        return staff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;

        Staff staff = (Staff) o;

        return items.equals(staff.items);
    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }

    @Override
    public String toString() {
        return "Staff{" +
                "items=" + items +
                "} " + super.toString();
    }
}
