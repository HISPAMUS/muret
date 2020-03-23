package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.IMetronomeMark;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.enums.mensural.EMensurations;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.Mensuration;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.mensurations.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.Number;
import es.ua.dlsi.grfia.moosicae.core.mensural.*;
import es.ua.dlsi.grfia.moosicae.core.metadata.ITitle;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class CoreAbstractFactoryImpl implements ICoreAbstractFactory {
    @Override
    public IAlteration createAlteration(@NotNull IId id, @NotNull IAccidentalSymbol accidentalSymbol, @Nullable IAlterationDisplayType alterationDisplayType) {
        return new Alteration(id, accidentalSymbol, alterationDisplayType);
    }

    @Override
    public IBarline createBarline(@NotNull IId id, @Nullable INumber barNumber, @Nullable IBarlineType barlineType) {
        return new Barline(id, barNumber, barlineType);
    }

    @Override
    public IChord createChord(@NotNull IId id, @NotNull IFigure figure, @Nullable IDots dots, @NotNull IPitch[] pitches) {
        return new Chord(id, figure, dots, pitches);
    }

    @Override
    public IClef createClef(@NotNull IId id, @NotNull IClefLine line, IClefSign clefSign) {
        return new Clef(id, line, clefSign);
    }

    @Override
    public IClefLine createClefLine(@NotNull IId id, @NotNull Integer line) {
        return new ClefLine(id, line);
    }

    @Override
    public ICommonTime createCommonTime(@NotNull IId id) {
        return new CommonTime(id);
    }

    @Override
    public ICustos createCustos(@NotNull IId id, @NotNull IPitch pitch) {
        return new Custos(id, pitch);
    }

    @Override
    public ICutTime createCutTime(@NotNull IId id) {
        return new CutTime(id);
    }

    @Override
    public IDots createDots(@NotNull IId id, @NotNull Integer ndots) {
        return new Dots(id, ndots);
    }

    @Override
    public IId createId() {
        return IdGenerator.getInstance().generateUniqueId();
    }

    @Override
    public IId createId(@NotNull String value) {
        return new ID(value);
    }

    private <T extends IKeyEnum> Optional<T> findKeyEnum(T[] values, IPitchClass pitchClass) {
        EDiatonicPitches diatonicPitch = pitchClass.getDiatonicPitch().getValue();
        Optional<EAccidentalSymbols> accidentalSymbol;
        if (pitchClass.getAccidental().isPresent()) {
            accidentalSymbol = Optional.of(pitchClass.getAccidental().get().getValue());
        } else {
            accidentalSymbol = Optional.empty();
        }

        for (T value: values) {
            if (Objects.equals(value.getDiatonicPitch(), diatonicPitch)
                && Objects.equals(value.getPitchAccidentalSymbol(), accidentalSymbol)) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
    @Override
    public IKey createKey(@NotNull IId id, @NotNull IPitchClass pitchClass, @NotNull IMode mode) throws IMException {
        // find the pitch class among the enums
        Optional<ECommonAlterationKeys> commonAlterationKey = findKeyEnum(ECommonAlterationKeys.values(), pitchClass);
        if (commonAlterationKey.isPresent()) {
            return createKey(id, commonAlterationKey.get());
        }

        Optional<ECommonAlterationKeys> mixedAlterationKey = findKeyEnum(ECommonAlterationKeys.values(), pitchClass);
        if (mixedAlterationKey.isPresent()) {
            return createKey(id, mixedAlterationKey.get());
        }

        throw new IMException("Cannot find a key for pitch class " + pitchClass + " and mode " + mode);
    }

    @Override
    public IKey createKey(@NotNull IId id, @NotNull IPitchClass pitchClass, @NotNull IMode mode, @NotNull IKeySignature keySignature) {
        return new Key(id, pitchClass, mode, keySignature);
    }

    @Override
    public ICommonAlterationKey createKey(@NotNull IId id, @NotNull IKeyAccidentalCount nAccidentals, @NotNull IAccidentalSymbol accidentalSymbol, @NotNull IMode mode) throws IMException {
        EModes modeValue = mode.getValue();
        EAccidentalSymbols accidentalSymbolValue = accidentalSymbol.getValue();
        for (ECommonAlterationKeys key: ECommonAlterationKeys.values()) {
            if (key.getMode().equals(modeValue)
                    && key.getKeySignatureAccidentalCount() == nAccidentals.getValue()
                    && key.getKeySignatureAccidental().isPresent()
                    && key.getKeySignatureAccidental().get().equals(accidentalSymbolValue)) {
                return createKey(id, key);
            }
        }
        throw new IMException("Cannot find a key with " + nAccidentals + " " + accidentalSymbol.getValue().name() + "s and mode " + mode.getValue());
    }

    @Override
    public IKeyAccidentalCount createKeyAccidentalCount(@NotNull IId id, @NotNull Integer nAccidentals) {
        return new KeyAccidentalCount(id, nAccidentals);
    }


    @Override
    public IKeySignature createKeySignature(@NotNull IId id, @NotNull IPitchClass[] pitchClasses) {
        return new KeySignature(id, pitchClasses);
    }

    @Override
    public IFractionalTimeSignature createFractionalTimeSignature(@NotNull IId id, @NotNull ITimeSignatureNumrerator numerator, @NotNull ITimeSignatureDenominator denominator) {
        return new FractionalTimeSignature(id, numerator, denominator);
    }

    @Override
    public IMensuration createMensuration(@NotNull IId id, @Nullable EMensuralPerfections modusMaior, @Nullable EMensuralPerfections modusMinor, @NotNull EMensuralPerfections tempus, @NotNull EMensuralPerfections prolatio) {
        Mensuration result;

        switch (tempus) {
            case imperfectum:
                if (prolatio == EMensuralPerfections.imperfectum) {
                    result = new TempusImperfectumCumProlationeImperfecta(id);
                } else if (prolatio == EMensuralPerfections.perfectum) {
                    result = new TempusImperfectumCumProlationePerfecta(id);
                } else {
                    throw new IMRuntimeException("Invalid prolatio: " + prolatio);
                }
                break;
            case perfectum:
                if (prolatio == EMensuralPerfections.imperfectum) {
                    result = new TempusPerfectumCumProlationeImperfecta(id);
                } else if (prolatio == EMensuralPerfections.perfectum) {
                    result = new TempusPerfectumCumProlationePerfecta(id);
                } else {
                    throw new IMRuntimeException("Invalid prolatio: " + prolatio);
                }
                break;
            default:
                throw new IMRuntimeException("Invalid tempus: " + tempus);
        }

        if (modusMaior != null) {
            result.setModusMaior(modusMaior);
        }
        if (modusMinor != null) {
            result.setModusMinor(modusMinor);
        }
        return result;
    }

    @Override
    public IMetronomeMark createMetronomeMark(@NotNull IId id, @NotNull IFigure figure, @Nullable IDots dots, @NotNull IMetronomeMarkValue value) {
        return new MetronomeMark(id, figure, dots, value);
    }

    @Override
    public IMetronomeMarkValue createMetronomeMarkValue(IId id, Integer value) {
        return new MetronomeMarkValue(id, value);
    }

    @Override
    public IMultimeasureRest createMultimeasureRest(@NotNull IId id, @NotNull IMultimeasureRestCount measureCount) {
        return new MultimeasureRest(id, measureCount);
    }

    @Override
    public IMultimeasureRestCount createMultimeasureRestCount(IId id, Integer value) {
        return new MultimeasureRestCount(id, value);
    }

    @Override
    public IName createName(@NotNull IId id, @NotNull String value) {
        return new Name(id, value);
    }

    @Override
    public INumber createNumber(@NotNull IId id, @NotNull Integer value) {
        return new Number(id, value);
    }

    @Override
    public INote createNote(@NotNull IId id, @NotNull IFigure figure, @Nullable IDots dots, @NotNull IPitch pitch) {
        return new Note(id, figure, dots, pitch);
    }


    @Override
    public IPitch createPitch(@NotNull IId id, @NotNull IOctave octave, @Nullable IAlteration alteration, @NotNull IDiatonicPitch diatonicPitch) {
        return new Pitch(id, octave, alteration,  diatonicPitch);
    }

    @Override
    public IPitchClass createPitchClass(@NotNull IId id, @NotNull IDiatonicPitch diatonicPitch, @Nullable IAccidentalSymbol accidentalSymbol) {
        return new PitchClass(id, diatonicPitch, accidentalSymbol);
    }

    @Override
    public IOctave createOctave(@NotNull IId id, @NotNull Integer number) {
        return new Octave(id, number);
    }


    @Override
    public ITitle createTitle(@NotNull IId id, @NotNull String title) {
        return new Title(id, title);
    }


    @Override
    public IPart createPart(@NotNull IScore score, @NotNull IId id, @Nullable IName name) {
        IPart part = new Part(id, name);
        score.add(part);
        return part;
    }

    @Override
    public IPart createPart(@NotNull IId id, @Nullable IName name) {
        return new Part(id, name);
    }


    @Override
    public IScore createScore(@NotNull IId id) {
        return new Score(id);
    }

    @Override
    public IRest createRest(@NotNull IId id, @NotNull IFigure figure, @Nullable IDots dots) {
        return new Rest(id, figure, dots);
    }

    @Override
    public IStaff createStaff(@NotNull IStaffGroup staves, @NotNull IId id) {
        Staff staff = new Staff(id);
        staves.add(staff);
        return null;
    }

    @Override
    public IStaff createStaff(@NotNull IScore score, @NotNull IId id) {
        Staff staff = new Staff(id);
        score.add(staff);
        return staff;
    }

    @Override
    public IStaffGroup createStaffGroup(@NotNull IScore score, @NotNull IId id) {
        StaffGroup staffGroup = new StaffGroup(id);
        score.add(staffGroup);
        return staffGroup;
    }

    @Override
    public IStaffGroup createStaffGroup(@NotNull IStaffGroup staffGroup, @NotNull IId id) {
        StaffGroup childStaffGroup = new StaffGroup(id);
        staffGroup.add(childStaffGroup);
        return childStaffGroup;
    }

    @Override
    public ITimeSignatureNumrerator createTimeSignatureNumerator(@NotNull IId id, @NotNull Integer value) {
        return new TimeSignatureNumerator(id, value);
    }

    @Override
    public ITimeSignatureDenominator createTimeSignatureDenominator(@NotNull IId id, @NotNull Integer value) {
        return new TimeSignatureDenominator(id, value);
    }

    @Override
    public IVoice createVoice(@NotNull IPart part, @NotNull IId id, @Nullable IName name) {
        Voice voice = new Voice(id, name);
        part.add(voice);
        return voice;
    }

    @Override
    public IBarlineType createBarlineType(@NotNull IId id, @NotNull EBarlineTypes barlineType) {
        return new BarlineType(id, barlineType);
    }

    @Override
    public IFigure createFigure(@NotNull IId id, @NotNull EFigures figure) {
        return new Figure(id, figure);
    }

    @Override
    public IAccidentalSymbol createAccidentalSymbol(@NotNull IId id, @NotNull EAccidentalSymbols accidentalSymbol) {
        return new AccidentalSymbol(id, accidentalSymbol);
    }

    @Override
    public IAlterationDisplayType createAlterationDisplayType(@NotNull IId id, @NotNull EAlterationDisplayTypes alterationDisplayType) {
        return new AlterationDisplayType(id, alterationDisplayType);
    }

    @Override
    public IClefSign createClefSign(@NotNull IId id, @NotNull EClefSigns clefSign) {
        return new ClefSign(id, clefSign);
    }

    @Override
    public IDiatonicPitch createDiatonicPitch(@NotNull IId id, @NotNull EDiatonicPitches diatonicPitch) {
        return new DiatonicPitch(id, diatonicPitch);
    }

    @Override
    public INotationType createNotationType(@NotNull IId id, @NotNull ENotationTypes notationType) {
        return new NotationType(id, notationType);
    }

    @Override
    public IMeterSymbol createMeterSymbol(@NotNull IId id, @NotNull EMeterSymbols meterSymbols) {
        switch (meterSymbols) {
            case commonTime:
                return new CommonTime(id);
            case cutTime:
                return new CutTime(id);
            default:
                throw new IMRuntimeException("Unknown meter symbol: " + meterSymbols);
        }
    }

    @Override
    public IMensuration createMensuration(@NotNull IId id, @NotNull EMensurations mensuration) {
        switch (mensuration) {
            case proportioTripla:
                return new ProportioTripla(id);
            case proportioChangeDupla:
                return new ProportioChangeDupla(id);
            case proportioChangeTripla:
                return new ProportioChangeTripla(id);
            case proportioSesquialtera:
                return new ProportioSesquialtera(id);
            case tempusImperfectumCumProlationeImperfecta:
                return new TempusImperfectumCumProlationeImperfecta(id);
            case tempusImperfectumCumProlationeImperfectaDiminutum:
                return new TempusImperfectumCumProlationeImperfectaDiminutum(id);
            case tempusImperfectumCumProlationePerfecta:
                return new TempusImperfectumCumProlationePerfecta(id);
            case tempusPerfectumCumProlationeImperfecta:
                return new TempusPerfectumCumProlationeImperfecta(id);
            case tempusPerfectumCumProlationePerfecta:
                return new TempusPerfectumCumProlationePerfecta(id);
            default:
                throw new IMRuntimeException("Unknown mensuration: " + mensuration);
        }
    }

    @Override
    public IMode createMode(@NotNull IId id, @NotNull EModes mode) {
        return new Mode(id, mode);
    }

    private final EDiatonicPitches [] SHARP_CIRCLE_FIFTHS = {
            EDiatonicPitches.F, EDiatonicPitches.C, EDiatonicPitches.G, EDiatonicPitches.D, EDiatonicPitches.A,
            EDiatonicPitches.E, EDiatonicPitches.B
    };

    private IPitchClass createPitchClass(IId id, EDiatonicPitches eDiatonicPitch, Optional<EAccidentalSymbols> eAccidentalSymbol) {
        IDiatonicPitch diatonicPitch = createDiatonicPitch(IdGenerator.getInstance().generateUniqueId(), eDiatonicPitch);
        IAccidentalSymbol accidentalSymbol = null;
        if (eAccidentalSymbol.isPresent()) {
            accidentalSymbol = createAccidentalSymbol(IdGenerator.getInstance().generateUniqueId(), eAccidentalSymbol.isPresent() ? eAccidentalSymbol.get() : null);
        }
        IPitchClass pitchClass = createPitchClass(id, diatonicPitch, accidentalSymbol);
        return pitchClass;
    }

    @Override
    public ICommonAlterationKey createKey(@NotNull IId id, @NotNull ECommonAlterationKeys commonKeys) {
        IPitchClass pitchClass = createPitchClass(IdGenerator.getInstance().generateUniqueId(), commonKeys.getDiatonicPitch(), commonKeys.getPitchAccidentalSymbol());
        IMode mode = createMode(id, commonKeys.getMode());

        IAccidentalSymbol keySignatureAccidentalSymbol = null;
        if (commonKeys.getKeySignatureAccidental().isPresent()) {
            keySignatureAccidentalSymbol = createAccidentalSymbol(IdGenerator.getInstance().generateUniqueId(), commonKeys.getKeySignatureAccidental().get());
        }

        IPitchClass [] pitchClasses = new IPitchClass[commonKeys.getKeySignatureAccidentalCount()];
        for (Integer i=0; i<commonKeys.getKeySignatureAccidentalCount(); i++) {
            IPitchClass pitchClassAccidental;
            if (commonKeys.getKeySignatureAccidental().get() == EAccidentalSymbols.FLAT) {
                pitchClassAccidental = createPitchClass(IdGenerator.getInstance().generateUniqueId(), SHARP_CIRCLE_FIFTHS[6-i], Optional.of(EAccidentalSymbols.FLAT));
            } else if (commonKeys.getKeySignatureAccidental().get() == EAccidentalSymbols.SHARP) {
                pitchClassAccidental = createPitchClass(IdGenerator.getInstance().generateUniqueId(), SHARP_CIRCLE_FIFTHS[i], Optional.of(EAccidentalSymbols.SHARP));
            } else {
                throw new IMRuntimeException("Invalid accidental in a common key " + commonKeys.getKeySignatureAccidental().get());
            }
            pitchClasses[i] = pitchClassAccidental;
        }

        return new CommonAlterationKey(id, pitchClass,
                mode,
                createKeySignature(IdGenerator.getInstance().generateUniqueId(), pitchClasses),
                commonKeys.getKeySignatureAccidentalCount(),
                keySignatureAccidentalSymbol
                );
    }

    @Override
    public IMixedAlterationsKey createKey(@NotNull IId id, @NotNull EMixedAlterationKeys mixedAlterationKeys) {
        IPitchClass pitchClass = createPitchClass(IdGenerator.getInstance().generateUniqueId(), mixedAlterationKeys.getDiatonicPitch(), mixedAlterationKeys.getAccidentalSymbol());
        IMode mode = createMode(IdGenerator.getInstance().generateUniqueId(), mixedAlterationKeys.getMode());

        IPitchClass [] pitchClasses = new IPitchClass[7];
        for (Integer i=0; i<mixedAlterationKeys.getFirstAlterationCount(); i++) {
            IPitchClass pitchClassAccidental;
            if (mixedAlterationKeys.getKeySignatureFirstAccidental() == EAccidentalSymbols.DOUBLE_FLAT) {
                pitchClassAccidental = createPitchClass(IdGenerator.getInstance().generateUniqueId(), SHARP_CIRCLE_FIFTHS[6-i], Optional.of(EAccidentalSymbols.DOUBLE_FLAT));
            } else if (mixedAlterationKeys.getKeySignatureFirstAccidental() == EAccidentalSymbols.DOUBLE_SHARP) {
                pitchClassAccidental = createPitchClass(IdGenerator.getInstance().generateUniqueId(), SHARP_CIRCLE_FIFTHS[i], Optional.of(EAccidentalSymbols.DOUBLE_SHARP));
            } else {
                throw new IMRuntimeException("Invalid accidental in a mixed alterations key " + mixedAlterationKeys.getKeySignatureFirstAccidental());
            }
            pitchClasses[i] = pitchClassAccidental;
        }

        for (Integer i = mixedAlterationKeys.getFirstAlterationCount(); i < 7; i++) {
            IPitchClass pitchClassAccidental;
            if (mixedAlterationKeys.getKeySignatureSecondAccidental().get() == EAccidentalSymbols.FLAT) {
                pitchClassAccidental = createPitchClass(IdGenerator.getInstance().generateUniqueId(), SHARP_CIRCLE_FIFTHS[6-i], Optional.of(EAccidentalSymbols.FLAT));
            } else if (mixedAlterationKeys.getKeySignatureSecondAccidental().get() == EAccidentalSymbols.SHARP) {
                pitchClassAccidental = createPitchClass(IdGenerator.getInstance().generateUniqueId(), SHARP_CIRCLE_FIFTHS[i], Optional.of(EAccidentalSymbols.SHARP));
            } else {
                throw new IMRuntimeException("Invalid accidental in a mixed alterations key " + mixedAlterationKeys.getKeySignatureSecondAccidental().get());
            }
            pitchClasses[i] = pitchClassAccidental;
        }

        return new MixedAlterationsKey(id, pitchClass,
                mode,
                createKeySignature(IdGenerator.getInstance().generateUniqueId(), pitchClasses));
    }

}
