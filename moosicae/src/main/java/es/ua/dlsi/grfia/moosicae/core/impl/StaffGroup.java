package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IStaff;
import es.ua.dlsi.grfia.moosicae.core.IStaffGroup;
import es.ua.dlsi.grfia.moosicae.core.ISystemElement;

import java.util.LinkedList;

public class StaffGroup extends Staves implements IStaffGroup {
    private final LinkedList<ISystemElement> children;

    public StaffGroup() {
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
}
