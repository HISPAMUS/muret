package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IStaff;
import es.ua.dlsi.grfia.moosicae.core.IStaffGroup;
import es.ua.dlsi.grfia.moosicae.core.IStaffOurGroup;

import java.util.Arrays;
import java.util.LinkedList;

public class StaffGroup extends Staves implements IStaffGroup {
    private final LinkedList<IStaffOurGroup> children;

    public StaffGroup() {
        children = new LinkedList<>();
    }

    @Override
    public IStaffOurGroup[] getChildren() {
        return children.toArray(new IStaffOurGroup[children.size()]);
    }

    @Override
    public void add(IStaffOurGroup child) {
        this.children.add(child);
    }

    @Override
    public IStaff[] getStaves() {
        LinkedList<IStaff> staves = new LinkedList<>();
        for (IStaffOurGroup child: children) {
            for (IStaff staff: child.getStaves()) {
                staves.add(staff);
            }
        }
        return staves.toArray(new IStaff[staves.size()]);
    }
}
