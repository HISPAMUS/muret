package es.ua.dlsi.grfia.moosicae.core;


import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.enums.mensural.EMensurations;
import es.ua.dlsi.grfia.moosicae.core.mensural.*;
import es.ua.dlsi.grfia.moosicae.core.metadata.ITitle;

import java.util.Optional;

/**
 * It knows how to create all main objects in the core package
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface ICoreAbstractFactory {
    IAlteration createAlteration(IAccidentalSymbol accidentals, Optional<IAlterationDisplayType> alterationDisplayType);
    IBarline createBarline(Optional<Integer> barNumber, Optional<IBarlineType> barlineType);
    IChord createChord(IFigure figures, Optional<IDots> dots, IPitch [] pitches);
    IClef createClef(int line, IClefSign clefSign);
    ICommonTime createCommonTime();
    ICustos createCustos(IPitch pitch);
    ICutTime createCutTime();
    IKeySignature createKeySignature(IPitchClass [] pitchClasses);
    IFractionalTimeSignature createFractionalTimeSignature(int numerator, int denominator);
    IMensuration createMensuration(EMensuralPerfections modusMaior, EMensuralPerfections modusMinor, EMensuralPerfections tempus, EMensuralPerfections prolatio);
    IMetronomeMark createMetronomeMark(IFigure figure, Optional<IDots> dots, int value);
    IMultimeasureRest createMultimeasureRest(int measureCount);
    INote createNote(IFigure figures, Optional<IDots> dots, IPitch pitches);
    IOctave createOctave(int number);
    IPart createPart(IScore score, String name);
    IPitch createPitch(IOctave octave, Optional<IAlteration> alteration, IDiatonicPitch diatonicPitch);
    IPitchClass createPitchClass(IDiatonicPitch diatonicPitch, Optional<IAccidentalSymbol> accidentalSymbol);

    IScore createScore();
    IRest createRest(IFigure figure, Optional<IDots> dots);

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


    /** Enum based **/
    IBarlineType createBarlineType(EBarlineTypes barlineType);
    IFigure createFigure(EFigures figure);
    IAccidentalSymbol createAccidentalSymbol(EAccidentalSymbols accidentalSymbol);
    IAlterationDisplayType createAlterationDisplayType(EAlterationDisplayTypes alterationDisplayType);
    IClefSign createClefSign(EClefSigns clefSign);
    IDiatonicPitch createDiatonicPitch(EDiatonicPitches diatonicPitch);
    INotationType createNotationType(ENotationTypes notationType);
    IMeterSymbol createMeterSymbol(EMeterSymbols meterSymbol);
    IMensuration createMensuration(EMensurations mensuration);
    IMode createMode(EModes mode);
    ICommonAlterationKey createKey(ECommonAlterationKeys commonAlterationKeys);
    IMixedAlterationsKey createKey(EMixedAlterationKeys mixedAlterationKeys);
}
