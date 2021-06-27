package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.INotationType;
import es.ua.dlsi.grfia.moosicae.core.properties.IStaffLineCount;

import javax.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Staff extends MooObject implements IStaff {
    @NotNull
    IStaffLineCount staffLineCount;

    INotationType notationType;

    @NotNull
    private final List<IVoicedSingle> items;

    public Staff(IId id, @NotNull IStaffLineCount staffLineCount, INotationType notationType) {
        super(id);
        this.staffLineCount = staffLineCount;
        items = new LinkedList<>();
        this.notationType = notationType;
    }

    public Staff(IId id, IStaffLineCount staffLineCount, IVoicedSingle[] items, INotationType notationType) {
        super(id);
        this.notationType = notationType;
        this.staffLineCount = staffLineCount;
        if (items != null) {
            this.items = Arrays.asList(items);
        } else {
            this.items = new LinkedList<>();
        }
    }

    @Override
    public INotationType getNotationType() {
        return notationType;
    }

    @Override
    public IVoicedSingle[] getStaffSymbols() {
        return items.toArray(new IVoicedSingle[items.size()]);
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
    public void put(IVoicedSingle symbol) {
        this.items.add(symbol);
    }

    @Override
    public void remove(IVoicedSingle symbol) {
        this.items.remove(symbol);
    }

    @Override
    public boolean isEmpty() {
        return this.items == null || items.isEmpty();
    }


    @Override
    public IStaff[] listStaves() {
        return new IStaff[] {this};
    }

    @Override
    public Staff clone() {
        Staff staff = new Staff(null, staffLineCount, notationType);
        for (IVoicedSingle symbol: items) {
            items.add(symbol); // do not clone, it's an aggregation
        }
        return staff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;

        Staff staff = (Staff) o;

        if (!staffLineCount.equals(staff.staffLineCount)) return false;
        if (notationType != null ? !notationType.equals(staff.notationType) : staff.notationType != null) return false;
        return items.equals(staff.items);
    }

    @Override
    public int hashCode() {
        int result = staffLineCount.hashCode();
        result = 31 * result + (notationType != null ? notationType.hashCode() : 0);
        result = 31 * result + items.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "items=" + items +
                "notationType=" + notationType +
                "} " + super.toString();
    }
}
