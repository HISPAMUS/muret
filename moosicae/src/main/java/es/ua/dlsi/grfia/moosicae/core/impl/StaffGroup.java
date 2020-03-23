package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class StaffGroup extends Staves implements IStaffGroup {
    @NotNull
    private final LinkedList<ISystemElement> children;

    public StaffGroup(@NotNull IId id) {
        super(id);
        children = new LinkedList<>();
    }

    @Override
    public ISystemElement[] getChildren() {
        return children.toArray(new ISystemElement[children.size()]);
    }

    @Override
    public void add(ISystemElement child) {
        this.children.add(child);
    }

    @Override
    public IStaff[] getStaves() {
        LinkedList<IStaff> staves = new LinkedList<>();
        for (ISystemElement child: children) {
            for (IStaff staff: child.getStaves()) {
                staves.add(staff);
            }
        }
        return staves.toArray(new IStaff[staves.size()]);
    }

    @Override
    public StaffGroup clone() {
        StaffGroup staffGroup = new StaffGroup(IdGenerator.getInstance().generateUniqueId());
        for (ISystemElement systemElement: children) {
            add((ISystemElement) systemElement.clone());
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
