package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Staff extends CoreObject implements IStaff {
    @NotNull
    private final LinkedList<ICoreItem> items;

    public Staff(@NotNull IId id) {
        super(id);
        items = new LinkedList<>();
    }

    @Override
    public ICoreItem[] getStaffSymbols() {
        return items.toArray(new ICoreItem[items.size()]);
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
        Staff staff = new Staff(IdGenerator.getInstance().generateUniqueId());
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
