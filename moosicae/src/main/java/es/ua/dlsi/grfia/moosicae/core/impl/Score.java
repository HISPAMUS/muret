package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.LinkedList;

public class Score implements IScore {
    private final LinkedList<IPart> parts;
    private final LinkedList<IStaffOurGroup> staffOurGroups;

    public Score() {
        parts = new LinkedList<>();
        staffOurGroups = new LinkedList<>();
    }

    @Override
    public IMetadata getMetadata() {
        return null;
    }

    @Override
    public IPart[] getParts() {
        return parts.toArray(new IPart[parts.size()]);
    }

    @Override
    public IStaffGroup[] getStaffOurGroups() {
        return staffOurGroups.toArray(new IStaffGroup[staffOurGroups.size()]);
    }

    @Override
    public IStaff[] getAllStaves() {
        LinkedList<IStaff> staves = new LinkedList<>();
        for (IStaffOurGroup child: staffOurGroups) {
            for (IStaff staff: child.getStaves()) {
                staves.add(staff);
            }
        }
        return staves.toArray(new IStaff[staves.size()]);
    }

    @Override
    public void add(IPart part) {
        this.parts.add(part);
    }

    @Override
    public void add(IStaffOurGroup staffOrGroup) {
        this.staffOurGroups.add(staffOrGroup);
    }
}
