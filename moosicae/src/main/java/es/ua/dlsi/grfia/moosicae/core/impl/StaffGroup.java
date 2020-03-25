package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class StaffGroup extends System implements IStaffGroup {
    @NotNull
    private final List<ISystem> children;

    public StaffGroup(IId id) {
        super(id);
        children = new LinkedList<>();
    }

    public StaffGroup(IId id, ISystem[] children) {
        super(id);
        this.children = Arrays.asList(children);
    }

    @Override
    public ISystem[] getChildren() {
        return children.toArray(new ISystem[children.size()]);
    }

    @Override
    public void add(ISystem child) {
        this.children.add(child);
    }

    @Override
    public IStaff[] getStaves() {
        LinkedList<IStaff> staves = new LinkedList<>();
        for (ISystem child: children) {
            for (IStaff staff: child.getStaves()) {
                staves.add(staff);
            }
        }
        return staves.toArray(new IStaff[staves.size()]);
    }

    @Override
    public StaffGroup clone() {
        StaffGroup staffGroup = new StaffGroup(null);
        for (ISystem systemElement: children) {
            add((ISystem) systemElement.clone());
        }
        return staffGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StaffGroup)) return false;

        StaffGroup that = (StaffGroup) o;

        return children.equals(that.children);
    }

    @Override
    public int hashCode() {
        return children.hashCode();
    }

    @Override
    public String toString() {
        return "StaffGroup{" +
                "children=" + children +
                "} " + super.toString();
    }
}
