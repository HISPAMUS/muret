package es.ua.dlsi.grfia.moosicae.core;


import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.enums.mensural.EMensurations;
import es.ua.dlsi.grfia.moosicae.core.mensural.*;
import es.ua.dlsi.grfia.moosicae.core.metadata.ITitle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * It knows how to create all main objects in the core package
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface ICoreAbstractFactory {
    IAlteration createAlteration(@NotNull IId id, @NotNull IAccidentalSymbol accidentals, @Nullable IAlterationDisplayType alterationDisplayType);
    IBarline createBarline(@NotNull IId id, @Nullable INumber barNumber, @Nullable IBarlineType barlineType);
    IChord createChord(@NotNull IId id, @NotNull IFigure figures, @Nullable IDots dots, @NotNull IPitch [] pitches);
    IClef createClef(@NotNull IId id, @NotNull IClefLine line, @NotNull IClefSign clefSign);
    IClefLine createClefLine(@NotNull IId id, @NotNull Integer line);
    ICommonTime createCommonTime(@NotNull IId id);
    ICustos createCustos(@NotNull IId id, @NotNull IPitch pitch);
    ICutTime createCutTime(@NotNull IId id);
    IDots createDots(@NotNull IId id, @NotNull Integer ndots);
    IId createId();
    IId createId(@NotNull String value);
    IKey createKey(@NotNull IId id, @NotNull IPitchClass pitchClass, @NotNull IMode mode) throws IMException;
    IKey createKey(@NotNull IId id, @NotNull IPitchClass pitchClass, @NotNull IMode mode, @NotNull IKeySignature keySignature);
    ICommonAlterationKey createKey(@NotNull IId id, @NotNull IKeyAccidentalCount nAccidentals, @NotNull IAccidentalSymbol accidentalSymbol, @NotNull IMode mode) throws IMException;
    IKeyAccidentalCount createKeyAccidentalCount(@NotNull IId id, @NotNull Integer nAccidentals);
    IKeySignature createKeySignature(@NotNull IId id, @NotNull IPitchClass [] pitchClasses);
    IFractionalTimeSignature createFractionalTimeSignature(@NotNull IId id, @NotNull ITimeSignatureNumrerator numerator, @NotNull ITimeSignatureDenominator denominator);
    IMensuration createMensuration(@NotNull IId id, @Nullable EMensuralPerfections modusMaior, @Nullable EMensuralPerfections modusMinor, @NotNull EMensuralPerfections tempus, @NotNull EMensuralPerfections prolatio);
    IMetronomeMark createMetronomeMark(@NotNull IId id, @NotNull IFigure figure, @Nullable IDots dots, @NotNull Integer value);
    IMultimeasureRest createMultimeasureRest(@NotNull IId id, @NotNull Integer measureCount);
    IName createName(@NotNull IId id, @NotNull String value);
    INumber createNumber(@NotNull IId id, @NotNull Integer value);
    INote createNote(@NotNull IId id, IFigure figures, @Nullable IDots dots, @NotNull IPitch pitches);
    IOctave createOctave(@NotNull IId id, @NotNull Integer number);

    /**
     * Creates and adds the part to the score
     * @return
     */
    IPart createPart(@NotNull IScore score, @NotNull IId id, @Nullable IName name);

    /**
     * Creates the part alone
     * @param id
     * @param name
     * @return
     */
    IPart createPart(@NotNull IId id, @Nullable IName name);
    IPitch createPitch(@NotNull IId id, @NotNull IOctave octave, @Nullable IAlteration alteration, @NotNull IDiatonicPitch diatonicPitch);
    IPitchClass createPitchClass(@NotNull IId id, @NotNull IDiatonicPitch diatonicPitch, @Nullable IAccidentalSymbol accidentalSymbol);

    IScore createScore(@NotNull IId id);
    IRest createRest(@NotNull IId id, @NotNull IFigure figure, @Nullable IDots dots);

    /**
     * For nested staff
     * @param staffGroup
     * @return
     */
    IStaff createStaff(@NotNull IStaffGroup staffGroup, @NotNull IId id);
    /**
     * For ungrouped staves
     * @param score
     * @return
     */
    IStaff createStaff(@NotNull IScore score, @NotNull IId id);
    IStaffGroup createStaffGroup(@NotNull IScore score, @NotNull IId id);
    /**
     * For nested groups
     * @param staffGroup
     * @return
     */
    IStaffGroup createStaffGroup(@NotNull IStaffGroup staffGroup, @NotNull IId id);

    ITimeSignatureNumrerator createTimeSignatureNumerator(@NotNull IId id, @NotNull Integer value);
    ITimeSignatureDenominator createTimeSignatureDenominator(@NotNull IId id, @NotNull Integer value);
    ITitle createTitle(@NotNull IId id, @NotNull String title);
    IVoice createVoice(@NotNull IPart part, @NotNull IId id, @Nullable IName name);


    /** Enum based **/
    IBarlineType createBarlineType(@NotNull IId id, @NotNull EBarlineTypes barlineType);
    IFigure createFigure(@NotNull IId id, @NotNull EFigures figure);
    IAccidentalSymbol createAccidentalSymbol(@NotNull IId id, @NotNull EAccidentalSymbols accidentalSymbol);
    IAlterationDisplayType createAlterationDisplayType(@NotNull IId id, @NotNull EAlterationDisplayTypes alterationDisplayType);
    IClefSign createClefSign(@NotNull IId id, @NotNull EClefSigns clefSign);
    IDiatonicPitch createDiatonicPitch(@NotNull IId id, @NotNull EDiatonicPitches diatonicPitch);
    INotationType createNotationType(@NotNull IId id, @NotNull ENotationTypes notationType);
    IMeterSymbol createMeterSymbol(@NotNull IId id, @NotNull EMeterSymbols meterSymbol);
    IMensuration createMensuration(@NotNull IId id, @NotNull EMensurations mensuration);
    IMode createMode(@NotNull IId id, EModes mode);
    ICommonAlterationKey createKey(@NotNull IId id, @NotNull ECommonAlterationKeys commonAlterationKeys);
    IMixedAlterationsKey createKey(@NotNull IId id, @NotNull EMixedAlterationKeys mixedAlterationKeys);

}
