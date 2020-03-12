package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;

public class CoreAbstractFactoryImpl implements ICoreAbstractFactory {
    @Override
    public IClef createClef(int line, ClefSignTypes clefSign) {
        return new Clef(line, clefSign);
    }

    @Override
    public IPart createPart(IScore score, String name) {
        IPart part = new Part(name);
        score.add(part);
        return part;
    }

    @Override
    public IPart createPart(IScore score) {
        IPart part = new Part();
        score.add(part);
        return part;
    }

    @Override
    public IVoice createVoice(IPart part) {
        Voice voice = new Voice();
        part.addVoice(voice);
        return voice;
    }

    @Override
    public IScore createScore() {
        return new Score();
    }

    @Override
    public IStaff createStaff(IStaffGroup staves) {
        Staff staff = new Staff();
        staves.add(staff);
        return null;
    }

    @Override
    public IStaff createStaff(IScore score) {
        Staff staff = new Staff();
        score.add(staff);
        return staff;
    }

    @Override
    public IStaffGroup createStaffGroup(IScore score) {
        StaffGroup staffGroup = new StaffGroup();
        score.add(staffGroup);
        return staffGroup;
    }

    @Override
    public IStaffGroup createStaffGroup(IStaffGroup staffGroup) {
        StaffGroup childStaffGroup = new StaffGroup();
        staffGroup.add(childStaffGroup);
        return childStaffGroup;
    }
}
