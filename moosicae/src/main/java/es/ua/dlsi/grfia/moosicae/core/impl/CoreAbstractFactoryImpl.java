package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.IMetronomeMark;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.enums.mensural.EMensurations;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.Mensuration;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.mensurations.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.Number;
import es.ua.dlsi.grfia.moosicae.core.mensural.*;
import es.ua.dlsi.grfia.moosicae.core.metadata.ITitle;
import es.ua.dlsi.grfia.moosicae.core.properties.*;


import javax.validation.constraints.NotNull;
import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.Optional;

/**
 * Note the @NotNull from interfaces are not actually checked by the hibernate validator
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class CoreAbstractFactoryImpl implements ICoreAbstractFactory {
    @Override
    public IAlteration createAlteration(IId id, IAccidentalSymbol accidentalSymbol,  IAlterationDisplayType alterationDisplayType) {
        return new Alteration(id, accidentalSymbol, alterationDisplayType);
    }

    @Override
    public IBarline createBarline(IId id,  INumber barNumber,  IBarlineType barlineType) {
        return new Barline(id, barNumber, barlineType);
    }

    @Override
    public IChord createChord(IId id, IFigure figure,  IDots dots, INoteHead[] noteHeads) {
        return new Chord(id, figure, dots, noteHeads);
    }

    @Override
    public IClef createClef(IId id, IClefSign clefSign, IClefLine line, IOctaveTransposition octaveTransposition) {
        return new Clef(id, clefSign, line, octaveTransposition);
    }

    @Override
    public IClefLine createClefLine(IId id, Integer line) {
        return new ClefLine(id, line);
    }

    @Override
    public ICommonTime createCommonTime(IId id) {
        return new CommonTime(id);
    }

    @Override
    public ICustos createCustos(IId id, IPitch pitch) {
        return new Custos(id, pitch);
    }

    @Override
    public ICutTime createCutTime(IId id) {
        return new CutTime(id);
    }

    @Override
    public IDots createDots(IId id, Integer ndots) {
        if (ndots == 0) {
            throw new IllegalArgumentException("When the number of dots is 0, this object should not be constructed");
        }
        return new Dots(id, ndots);
    }

    @Override
    public IId createId() {
        return null;
    }

    @Override
    public IId createId(String value) {
        return new ID(value, false);
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
    public IKey createKey(IId id, IPitchClass pitchClass, IMode mode, ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals) throws IMException {
        // find the pitch class among the enums
        Optional<EConventionalKeys> commonAlterationKey = findKeyEnum(EConventionalKeys.values(), pitchClass);
        if (commonAlterationKey.isPresent()) {
            return createConventionalKey(id, commonAlterationKey.get(), cautionaryKeySignatureAccidentals);
        }

        Optional<ETheoreticalKeys> theoreticalKey = findKeyEnum(ETheoreticalKeys.values(), pitchClass);
        if (commonAlterationKey.isPresent()) {
            return createConventionalKey(id, commonAlterationKey.get(), cautionaryKeySignatureAccidentals);
        }

        throw new IMException("Cannot find a key for pitch class " + pitchClass + " and mode " + mode);
    }

    @Override
    public IKey createKey(IId id, IPitchClass pitchClass, IMode mode, IKeySignature keySignature) {
        return new Key(id, pitchClass, mode, keySignature);
    }

    @Override
    public IConventionalKeySignature createConventionalKeySignature(IId id, @NotNull IKeyAccidentalCount keyAccidentalCount, IAccidentalSymbol accidentalSymbol, ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals) {
        if (keyAccidentalCount == null) {
            throw new IllegalArgumentException("accidentalCount");
        }

        return new ConventionalKeySignature(null, keyAccidentalCount, accidentalSymbol, cautionaryKeySignatureAccidentals);
    }

    @Override
    public IKeyAccidentalCount createKeyAccidentalCount(IId id, Integer nAccidentals) {
        return new KeyAccidentalCount(id, nAccidentals);
    }


    @Override
    public IUnconventionalKeySignature createUnconventionalKeySignature(IId id, IPitchClass[] pitchClasses, ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals) {
        return new UnconventionalKeySignature(id, pitchClasses, cautionaryKeySignatureAccidentals);
    }

    @Override
    public IStandardTimeSignature createStandardTimeSignature(IId id, ITimeSignatureNumerator numerator, ITimeSignatureDenominator denominator) {
        return new StandardTimeSignature(id, numerator, denominator);
    }

    @Override
    public IMensuration createMensuration(IId id,  EMensuralPerfections modusMaior,  EMensuralPerfections modusMinor, EMensuralPerfections tempus, EMensuralPerfections prolatio) {
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
    public IMetronomeMark createMetronomeMark(IId id, IFigure figure,  IDots dots, IMetronomeMarkValue value) {
        return new MetronomeMark(id, figure, dots, value);
    }

    @Override
    public IMetronomeMarkValue createMetronomeMarkValue(IId id, Integer value) {
        return new MetronomeMarkValue(id, value);
    }

    @Override
    public IMixedMeter createMixedMeter(IId id, @NotNull IMeter[] meters) {
        return new MixedMeter(id, meters);
    }

    @Override
    public IAlternatingMeter createAlternatingMeter(IId id, @NotNull IMeter[] meters) {
        return new AlternatingMeter(id, meters);
    }

    @Override
    public IAdditiveMeter createAdditiveMeter(IId id, @NotNull ITimeSignatureNumerator[] numerators, @NotNull ITimeSignatureDenominator denominator) {
        return new AdditiveMeter(id, numerators, denominator);
    }

    @Override
    public IMultimeasureRest createMultimeasureRest(IId id, IMultimeasureRestCount measureCount) {
        return new MultimeasureRest(id, measureCount);
    }

    @Override
    public IMultimeasureRestCount createMultimeasureRestCount(IId id, Integer value) {
        return new MultimeasureRestCount(id, value);
    }

    @Override
    public IName createName(IId id, String value) {
        return new Name(id, value);
    }

    @Override
    public INumber createNumber(IId id, Integer value) {
        return new Number(id, value);
    }

    @Override
    public INote createNote(IId id, IFigure figure,  IDots dots, INoteHead noteHead) {
        return new Note(id, figure, dots, noteHead);
    }

    @Override
    public INoteHead createNoteHead(IId id, @NotNull IPitch pitch, ITie tiedToNext) {
        return new NoteHead(id, pitch, tiedToNext);
    }


    @Override
    public IPitch createPitch(IId id, IOctave octave,  IAlteration alteration, IDiatonicPitch diatonicPitch) {
        return new Pitch(id, octave, alteration,  diatonicPitch);
    }

    @Override
    public IPitchClass createPitchClass(IId id, IDiatonicPitch diatonicPitch,  IAccidentalSymbol accidentalSymbol) {
        return new PitchClass(id, diatonicPitch, accidentalSymbol);
    }

    @Override
    public IOctave createOctave(IId id, Integer number) {
        return new Octave(id, number);
    }

    @Override
    public IOctaveTransposition createOctaveTransposition(IId id, @NotNull Integer value) {
        return new OctaveTransposition(id, value);
    }


    @Override
    public ITitle createTitle(IId id, String title) {
        return new Title(id, title);
    }


    @Override
    public IPart createPart(IScore score, IId id,  IName name) {
        IPart part = new Part(id, name);
        score.add(part);
        return part;
    }

    @Override
    public IPart createPart(IId id,  IName name) {
        return new Part(id, name);
    }


    @Override
    public IScore createScore(IId id) {
        return new Score(id);
    }

    @Override
    public IRest createRest(IId id, IFigure figure,  IDots dots) {
        return new Rest(id, figure, dots);
    }

    @Override
    public IStaff createStaff(IId id, @NotNull IStaffLineCount staffLineCount, @NotNull @NotNull IVoicedItem[] items) {
        return new Staff(id, staffLineCount, items);
    }

    @Override
    public IStaff createStaff(IStaffGroup staves, IId id, IStaffLineCount staffLineCount) {
        Staff staff = new Staff(id, staffLineCount);
        staves.add(staff);
        return staff;
    }

    @Override
    public IStaff createStaff(IScore score, IId id, IStaffLineCount staffLineCount) {
        Staff staff = new Staff(id, staffLineCount);
        score.add(staff);
        return staff;
    }

    @Override
    public IStaffGroup createStaffGroup(IId id, ISystem[] children) {
        return new StaffGroup(id, children);
    }

    @Override
    public IStaffGroup createStaffGroup(IScore score, IId id) {
        StaffGroup staffGroup = new StaffGroup(id);
        score.add(staffGroup);
        return staffGroup;
    }

    @Override
    public IStaffGroup createStaffGroup(IStaffGroup staffGroup, IId id) {
        StaffGroup childStaffGroup = new StaffGroup(id);
        staffGroup.add(childStaffGroup);
        return childStaffGroup;
    }

    @Override
    public IStaffLineCount createStaffLineCount(int value) {
        return new StaffLineCount(null, value);
    }

    @Override
    public ITie createTie(IId id, ITieOrientation tieOrientation) {
        return new Tie(id, tieOrientation);
    }

    @Override
    public ITimeSignatureNumerator createTimeSignatureNumerator(IId id, Integer value) {
        return new TimeSignatureNumerator(id, value);
    }

    @Override
    public ITimeSignatureDenominator createTimeSignatureDenominator(IId id, Integer value) {
        return new TimeSignatureDenominator(id, value);
    }

    @Override
    public IVoice createVoice(IPart part, IId id,  IName name) {
        Voice voice = new Voice(id, name);
        part.add(voice);
        return voice;
    }

    @Override
    public IInterchangingMeter createInterchangingMeter(IId id, IMeter left, IMeter right) throws IMException {
        return new InterchangingMeter(id, left, right);
    }

    @Override
    public IBarlineType createBarlineType(IId id, EBarlineTypes barlineType) {
        return new BarlineType(id, barlineType);
    }

    @Override
    public ICautionaryKeySignatureAccidentals createCautionaryKeySignatureAccidentals(IId id, @NotNull Boolean value) {
        return new CautionaryKeySignatureAccidentals(id, value);
    }

    @Override
    public IFigure createFigure(IId id, EFigures figure) {
        return new Figure(id, figure);
    }

    @Override
    public IAccidentalSymbol createAccidentalSymbol(IId id, EAccidentalSymbols accidentalSymbol) {
        return new AccidentalSymbol(id, accidentalSymbol);
    }

    @Override
    public IAlterationDisplayType createAlterationDisplayType(IId id, EAlterationDisplayTypes alterationDisplayType) {
        return new AlterationDisplayType(id, alterationDisplayType);
    }

    @Override
    public IClefSign createClefSign(IId id, EClefSigns clefSign) {
        return new ClefSign(id, clefSign);
    }

    @Override
    public IDiatonicPitch createDiatonicPitch(IId id, EDiatonicPitches diatonicPitch) {
        return new DiatonicPitch(id, diatonicPitch);
    }

    @Override
    public INotationType createNotationType(IId id, ENotationTypes notationType) {
        return new NotationType(id, notationType);
    }

    @Override
    public IMensuration createMensuration(IId id, EMensurations mensuration) {
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
    public IMode createMode(IId id, EModes mode) {
        return new Mode(id, mode);
    }

    private IPitchClass createPitchClass(IId id, EDiatonicPitches eDiatonicPitch, Optional<EAccidentalSymbols> eAccidentalSymbol) {
        IDiatonicPitch diatonicPitch = createDiatonicPitch(null, eDiatonicPitch);
        IAccidentalSymbol accidentalSymbol = null;
        if (eAccidentalSymbol.isPresent()) {
            accidentalSymbol = createAccidentalSymbol(null, eAccidentalSymbol.isPresent() ? eAccidentalSymbol.get() : null);
        }
        IPitchClass pitchClass = createPitchClass(id, diatonicPitch, accidentalSymbol);
        return pitchClass;
    }

    @Override
    public IKey createConventionalKey(IId id, EConventionalKeys commonKeys, ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals) {
        IPitchClass pitchClass = createPitchClass(null, commonKeys.getDiatonicPitch(), commonKeys.getPitchAccidentalSymbol());
        IMode mode = createMode(id, commonKeys.getMode());

        IAccidentalSymbol keySignatureAccidentalSymbol = null;
        if (commonKeys.getKeySignatureAccidental().isPresent()) {
            keySignatureAccidentalSymbol = createAccidentalSymbol(null, commonKeys.getKeySignatureAccidental().get());
        }

        IKeyAccidentalCount keyAccidentalCount = new KeyAccidentalCount(null, commonKeys.getKeySignatureAccidentalCount());
        ConventionalKeySignature conventionalKeySignature = new ConventionalKeySignature(null, keyAccidentalCount, keySignatureAccidentalSymbol, cautionaryKeySignatureAccidentals);
        Key key = new Key(null, pitchClass, mode, conventionalKeySignature);

        return key;
    }

    private final EDiatonicPitches [] SHARP_CIRCLE_FIFTHS = {
            EDiatonicPitches.F, EDiatonicPitches.C, EDiatonicPitches.G, EDiatonicPitches.D, EDiatonicPitches.A,
            EDiatonicPitches.E, EDiatonicPitches.B
    };

    @Override
    public ITheoreticalKey createTheoreticalKey(IId id, ETheoreticalKeys mixedAlterationKeys, ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals) {
        IPitchClass pitchClass = createPitchClass(null, mixedAlterationKeys.getDiatonicPitch(), mixedAlterationKeys.getPitchAccidentalSymbol());
        IMode mode = createMode(null, mixedAlterationKeys.getMode());

        IPitchClass [] pitchClasses = new IPitchClass[7];
        for (Integer i=0; i<mixedAlterationKeys.getFirstAlterationCount(); i++) {
            IPitchClass pitchClassAccidental;
            if (mixedAlterationKeys.getKeySignatureFirstAccidental() == EAccidentalSymbols.DOUBLE_FLAT) {
                pitchClassAccidental = createPitchClass(null, SHARP_CIRCLE_FIFTHS[6-i], Optional.of(EAccidentalSymbols.DOUBLE_FLAT));
            } else if (mixedAlterationKeys.getKeySignatureFirstAccidental() == EAccidentalSymbols.DOUBLE_SHARP) {
                pitchClassAccidental = createPitchClass(null, SHARP_CIRCLE_FIFTHS[i], Optional.of(EAccidentalSymbols.DOUBLE_SHARP));
            } else {
                throw new IMRuntimeException("Invalid accidental in a mixed alterations key " + mixedAlterationKeys.getKeySignatureFirstAccidental());
            }
            pitchClasses[i] = pitchClassAccidental;
        }

        for (Integer i = mixedAlterationKeys.getFirstAlterationCount(); i < 7; i++) {
            IPitchClass pitchClassAccidental;
            if (mixedAlterationKeys.getKeySignatureSecondAccidental().get() == EAccidentalSymbols.FLAT) {
                pitchClassAccidental = createPitchClass(null, SHARP_CIRCLE_FIFTHS[6-i], Optional.of(EAccidentalSymbols.FLAT));
            } else if (mixedAlterationKeys.getKeySignatureSecondAccidental().get() == EAccidentalSymbols.SHARP) {
                pitchClassAccidental = createPitchClass(null, SHARP_CIRCLE_FIFTHS[i], Optional.of(EAccidentalSymbols.SHARP));
            } else {
                throw new IMRuntimeException("Invalid accidental in a mixed alterations key " + mixedAlterationKeys.getKeySignatureSecondAccidental().get());
            }
            pitchClasses[i] = pitchClassAccidental;
        }

        return new TheoreticalKey(id, pitchClass,
                mode,
                createUnconventionalKeySignature(null, pitchClasses, cautionaryKeySignatureAccidentals));
    }

}
