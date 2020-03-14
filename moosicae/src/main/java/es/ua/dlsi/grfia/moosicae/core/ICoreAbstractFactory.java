package es.ua.dlsi.grfia.moosicae.core;


import es.ua.dlsi.grfia.moosicae.core.mensural.*;
import es.ua.dlsi.grfia.moosicae.core.metadata.ITitle;

import java.util.Optional;

/**
 * It knows how to create all main objects in the core package
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface ICoreAbstractFactory {
    IAlteration createAlteration(EAccidentals accidentals, Optional<EAlterationDisplayType> alterationDisplayType);
    IChord createChord(EFigures figures, Optional<IDots> dots, IPitch [] pitches);
    IClef createClef(int line, EClefSigns clefSign);
    ICommonTime createCommonTime();
    ICustos createCustos(IPitch pitch);
    ICutTime createCutTime();
    IKeySignature createKeySignature(IPitchClass [] pitchClasses);
    IFractionalTimeSignature createFractionalTimeSignature(int numerator, int denominator);
    IMensuration createMensuration(EMensuralPerfections modusMaior, EMensuralPerfections modusMinor, EMensuralPerfections tempus, EMensuralPerfections prolatio);
    INote createNote(EFigures figures, Optional<IDots> dots, IPitch pitches);
    IOctave createOctave(int number);
    IPart createPart(IScore score, String name);
    IPitch createPitch(IOctave octave, IAlteration alteration, EDiatonicPitches diatonicPitch);
    IProportioChangeDupla createProportioChangeDupla();
    IProportioChangeTripla createProportioChangeTripla();
    IProportioSesquialtera createProportioSesquialtera();
    IProportioTripla createProportioTripla();
    IScore createScore();
    ITempusImperfectumCumProlationeImperfecta createTempusImperfectumCumProlationeImperfecta();
    ITempusImperfectumCumProlationeImperfectaDiminutum createTempusImperfectumCumProlationeImperfectaDominitum();
    ITempusImperfectumCumProlationePerfecta createTempusImperfectumCumProlationePerfecta();
    ITempusPerfectumCumProlationeImperfecta createTempusPerfectumCumProlationeImperfecta();
    ITempusPerfectumCumProlationePerfecta createTempusPerfectumCumProlationePerfecta();

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

    ITitle createTitle(String title);
    IVoice createVoice(IPart part);



}
