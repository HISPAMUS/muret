package es.ua.dlsi.grfia.moosicae.core;


import es.ua.dlsi.grfia.moosicae.core.metadata.ITitle;

/**
 * It knows how to create all main objects in the core package
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface ICoreAbstractFactory {
    IAlteration createAlteration(EAccidentals accidentals, EAlterationDisplayType alterationDisplayType);
    IPitch createPitch(IOctave octave, IAlteration alteration, EDiatonicPitches diatonicPitch);
    IOctave createOctave(int number);
    ICustos createCustos(IPitch pitch);
    ITitle createTitle(String title);

    IClef createClef(int line, EClefSigns clefSign);
    IKeySignature createKeySignature(IPitchClass [] pitchClasses);
    IPart createPart(IScore score, String name);
    IPart createPart(IScore score);
    IVoice createVoice(IPart part);
    IScore createScore();

    /**
     * For nested staff
     * @param staffGroup
     * @return
     */
    IStaff createStaff(IStaffGroup staffGroup);

    /**
     * For ungrouped staves
     * @param score
     * @return
     */
    IStaff createStaff(IScore score);
    IStaffGroup createStaffGroup(IScore score);

    /**
     * For nested groups
     * @param staffGroup
     * @return
     */
    IStaffGroup createStaffGroup(IStaffGroup staffGroup);
}
