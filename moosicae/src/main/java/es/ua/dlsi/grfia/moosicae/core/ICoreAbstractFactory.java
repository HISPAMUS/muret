package es.ua.dlsi.grfia.moosicae.core;


import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.enums.mensural.EMensurations;
import es.ua.dlsi.grfia.moosicae.core.mensural.*;
import es.ua.dlsi.grfia.moosicae.core.metadata.ITitle;
import es.ua.dlsi.grfia.moosicae.core.properties.*;

import javax.validation.constraints.NotNull;


/**
 * It knows how to create all main objects in the core package
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface ICoreAbstractFactory {
    IAdditiveMeter createAdditiveMeter(IId id, @NotNull ITimeSignatureNumerator[] numerators, @NotNull ITimeSignatureDenominator denominator);
    IAlteration createAlteration(IId id, @NotNull IAccidentalSymbol accidentals, IAlterationDisplayType alterationDisplayType);
    IAlternatingMeter createAlternatingMeter(IId id, @NotNull IMeter[] meters);
    IAlterationDisplayType createAlterationDisplayType(IId id, @NotNull EAlterationDisplayTypes alterationDisplayType);
    IAccidentalSymbol createAccidentalSymbol(IId id, @NotNull EAccidentalSymbols accidentalSymbol);
    IBarline createBarline(IId id,  INumber barNumber,  IBarlineType barlineType);
    IBarlineType createBarlineType(IId id, @NotNull EBarlineTypes barlineType);
    ICautionaryKeySignatureAccidentals createCautionaryKeySignatureAccidentals(IId id, @NotNull Boolean value);
    IChord createChord(IId id, @NotNull IFigure figures,  IDots dots, @NotNull INoteHead [] noteHead);
    IClef createClef(IId id, @NotNull IClefSign clefSign, IClefLine line, IOctaveTransposition octaveTransposition);
    IClefLine createClefLine(IId id, @NotNull Integer line);
    IClefSign createClefSign(IId id, @NotNull EClefSigns clefSign);
    ICommonTime createCommonTime(IId id);
    IConventionalKeySignature createConventionalKeySignature(IId id, @NotNull IKeyAccidentalCount keyAccidentalCount, IAccidentalSymbol accidentalSymbol, ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals);
    ICustos createCustos(IId id, @NotNull IPitch pitch);
    ICutTime createCutTime(IId id);
    IDiatonicPitch createDiatonicPitch(IId id, @NotNull EDiatonicPitches diatonicPitch);

    IDot createDot(IId id);
    /**
     * @param id
     * @param dots Non empty array
     * @return
     */
    IDots createDots(IId id, @NotNull IDot[] dots);

    /**
     * Some formats just provide the number of dots
     * @param id
     * @param ndots > 0
     * @return
     */
    IDots createDots(IId id, int ndots);
    IFigure createFigure(IId id, @NotNull EFigures figure);
    IId createId();
    IId createId(@NotNull String value);
    IKey createConventionalKey(IId id, @NotNull EConventionalKeys commonAlterationKeys, ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals);
    ITheoreticalKey createTheoreticalKey(IId id, @NotNull ETheoreticalKeys mixedAlterationKeys, ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals);
    IKey createKey(IId id, @NotNull IPitchClass pitchClass, @NotNull IMode mode, ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals) throws IMException;
    IKey createKey(IId id, @NotNull IPitchClass pitchClass, @NotNull IMode mode, @NotNull IKeySignature keySignature);
    IKeyAccidentalCount createKeyAccidentalCount(IId id, @NotNull Integer nAccidentals);
    IUnconventionalKeySignature createUnconventionalKeySignature(IId id, @NotNull IPitchClass [] pitchClasses, ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals);
    IStandardTimeSignature createStandardTimeSignature(IId id, @NotNull ITimeSignatureNumerator numerator, @NotNull ITimeSignatureDenominator denominator);
    IMensuration createMensuration(IId id, @NotNull EMensurations mensuration);
    IMensuration createMensuration(IId id,  EMensuralPerfections modusMaior,  EMensuralPerfections modusMinor, @NotNull EMensuralPerfections tempus, @NotNull EMensuralPerfections prolatio);
    IMetronomeMark createMetronomeMark(IId id, @NotNull IFigure figure,  IDots dots, @NotNull IMetronomeMarkValue value);
    IMetronomeMarkValue createMetronomeMarkValue(IId id, @NotNull Integer value);
    IMixedMeter createMixedMeter(IId id, @NotNull IMeter[] meters);
    IMode createMode(IId id, EModes mode);
    IMultimeasureRest createMultimeasureRest(IId id, @NotNull IMultimeasureRestCount measureCount);
    IMultimeasureRestCount createMultimeasureRestCount(IId id, Integer value);

    IName createName(IId id, @NotNull String value);
    INotationType createNotationType(IId id, @NotNull ENotationTypes notationType);
    INumber createNumber(IId id, @NotNull Integer value);
    INote createNote(IId id, IFigure figures,  IDots dots, @NotNull INoteHead noteHead);

    /**
     *
     * @param id
     * @param pitch
     * @param tieToNext The note head (right) to which this note head (left) will be tied to
     * @return
     */
    INoteHead createNoteHead(IId id, @NotNull IPitch pitch, ITie tieToNext);
    IOctave createOctave(IId id, @NotNull Integer number);
    IOctaveTransposition createOctaveTransposition(IId id, @NotNull Integer value);

    /**
     * Creates and adds the part to the score
     * @return
     */
    IPart createPart(@NotNull IScore score, IId id,  IName name);

    /**
     * Creates the part alone
     * @param id
     * @param name
     * @return
     */
    IPart createPart(IId id,  IName name);
    IPitch createPitch(IId id, @NotNull IOctave octave,  IAlteration alteration, @NotNull IDiatonicPitch diatonicPitch);
    IPitchClass createPitchClass(IId id, @NotNull IDiatonicPitch diatonicPitch,  IAccidentalSymbol accidentalSymbol);

    IScore createScore(IId id);
    IRest createRest(IId id, @NotNull IFigure figure,  IDots dots);

    IStaff createStaff(IId id, @NotNull IStaffLineCount staffLineCount, @NotNull IVoicedItem[] items);

    /**
     * For nested staff. It adds the staff to the staff group
     * @param staffGroup
     * @return
     */
    IStaff createStaff(@NotNull IStaffGroup staffGroup, IId id, @NotNull IStaffLineCount staffLineCount);
    /**
     * For ungrouped staves. It adds the staff to the score
     * @param score
     * @return
     */
    IStaff createStaff(@NotNull IScore score, IId id, @NotNull IStaffLineCount staffLineCount);
    IStaffGroup createStaffGroup(IId id, ISystem[] children);

    /**
     * It adds the staff group to the score
     * @param score
     * @param id
     * @return
     */
    IStaffGroup createStaffGroup(@NotNull IScore score, IId id);
    /**
     * For nested groups. It adds the staff group to the parent staff group
     * @param staffGroup
     * @return
     */
    IStaffGroup createStaffGroup(@NotNull IStaffGroup staffGroup, IId id);
    IStaffLineCount createStaffLineCount(int value);

    ITie createTie(IId  id, ITieOrientation tieOrientation);
    ITimeSignatureNumerator createTimeSignatureNumerator(IId id, @NotNull Integer value);
    ITimeSignatureDenominator createTimeSignatureDenominator(IId id, @NotNull Integer value);
    ITitle createTitle(IId id, @NotNull String title);
    IVoice createVoice(@NotNull IPart part, IId id,  IName name);

    IInterchangingMeter createInterchangingMeter(IId id, IMeter left, IMeter right) throws IMException;
}
