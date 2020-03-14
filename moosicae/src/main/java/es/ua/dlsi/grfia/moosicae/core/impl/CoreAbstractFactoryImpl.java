package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.metadata.ITitle;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class CoreAbstractFactoryImpl implements ICoreAbstractFactory {
    @Override
    public IAlteration createAlteration(EAccidentals accidentals, EAlterationDisplayType alterationDisplayType) {
        return new Alteration(accidentals, alterationDisplayType);
    }

    @Override
    public IPitch createPitch(IOctave octave, IAlteration alteration, EDiatonicPitches diatonicPitch) {
        return new Pitch(octave, alteration,  diatonicPitch);
    }

    @Override
    public IOctave createOctave(int number) {
        return new Octave(number);
    }

    @Override
    public ICustos createCustos(IPitch pitch) {
        return new Custos(pitch);
    }

    @Override
    public ITitle createTitle(String title) {
        return new Title(title);
    }

    @Override
    public IClef createClef(int line, EClefSigns clefSign) {
        return new Clef(line, clefSign);
    }

    @Override
    public IKeySignature createKeySignature(IPitchClass[] pitchClasses) {
        return new KeySignature(pitchClasses);
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
