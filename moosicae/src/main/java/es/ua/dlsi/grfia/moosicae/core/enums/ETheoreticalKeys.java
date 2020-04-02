package es.ua.dlsi.grfia.moosicae.core.enums;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;
import es.ua.dlsi.grfia.moosicae.core.utils.ICircleOfFifths;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Keys that have the two different kinds of accidental in the key signature. There are always 7 alterations
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public enum ETheoreticalKeys implements IKeyEnum {
    GsM (EDiatonicPitches.G, EAccidentalSymbols.SHARP, EModes.major, 1, EAccidentalSymbols.DOUBLE_SHARP, EAccidentalSymbols.SHARP),
    Esm (EDiatonicPitches.E, EAccidentalSymbols.SHARP, EModes.minor, 1, EAccidentalSymbols.DOUBLE_SHARP, EAccidentalSymbols.SHARP),
    DsM (EDiatonicPitches.D, EAccidentalSymbols.SHARP, EModes.major, 2, EAccidentalSymbols.DOUBLE_SHARP, EAccidentalSymbols.SHARP),
    Bsm (EDiatonicPitches.B, EAccidentalSymbols.SHARP, EModes.minor, 2, EAccidentalSymbols.DOUBLE_SHARP, EAccidentalSymbols.SHARP),
    AsM (EDiatonicPitches.A, EAccidentalSymbols.SHARP, EModes.major, 3, EAccidentalSymbols.DOUBLE_SHARP, EAccidentalSymbols.SHARP),
    Fxm (EDiatonicPitches.F, EAccidentalSymbols.DOUBLE_SHARP, EModes.minor, 3, EAccidentalSymbols.DOUBLE_SHARP, EAccidentalSymbols.SHARP),
    EsM (EDiatonicPitches.E, EAccidentalSymbols.SHARP, EModes.major, 4, EAccidentalSymbols.DOUBLE_SHARP, EAccidentalSymbols.SHARP),
    Cxm (EDiatonicPitches.C, EAccidentalSymbols.DOUBLE_SHARP, EModes.minor, 4, EAccidentalSymbols.DOUBLE_SHARP, EAccidentalSymbols.SHARP),
    BsM (EDiatonicPitches.B, EAccidentalSymbols.SHARP, EModes.major, 5, EAccidentalSymbols.DOUBLE_SHARP, EAccidentalSymbols.SHARP),
    Gxm (EDiatonicPitches.G, EAccidentalSymbols.DOUBLE_SHARP, EModes.minor, 5, EAccidentalSymbols.DOUBLE_SHARP, EAccidentalSymbols.SHARP),
    FxM (EDiatonicPitches.F, EAccidentalSymbols.DOUBLE_SHARP, EModes.major, 6, EAccidentalSymbols.DOUBLE_SHARP, EAccidentalSymbols.SHARP),
    Dxm (EDiatonicPitches.D, EAccidentalSymbols.DOUBLE_SHARP, EModes.minor, 6, EAccidentalSymbols.DOUBLE_SHARP, EAccidentalSymbols.SHARP),
    CxM (EDiatonicPitches.C, EAccidentalSymbols.DOUBLE_SHARP, EModes.major, 7, EAccidentalSymbols.DOUBLE_SHARP, null),
    Axm (EDiatonicPitches.A, EAccidentalSymbols.DOUBLE_SHARP, EModes.minor, 7, EAccidentalSymbols.DOUBLE_SHARP, null),

    FbM (EDiatonicPitches.F, EAccidentalSymbols.FLAT, EModes.major, 1, EAccidentalSymbols.DOUBLE_FLAT, EAccidentalSymbols.FLAT),
    Dbm (EDiatonicPitches.D, EAccidentalSymbols.FLAT, EModes.minor, 1, EAccidentalSymbols.DOUBLE_FLAT, EAccidentalSymbols.FLAT),
    BbbM (EDiatonicPitches.B, EAccidentalSymbols.DOUBLE_FLAT, EModes.major, 2, EAccidentalSymbols.DOUBLE_FLAT, EAccidentalSymbols.FLAT),
    Gbm (EDiatonicPitches.G, EAccidentalSymbols.FLAT, EModes.minor, 2, EAccidentalSymbols.DOUBLE_FLAT, EAccidentalSymbols.FLAT),
    EbbM (EDiatonicPitches.E, EAccidentalSymbols.DOUBLE_FLAT, EModes.major, 3, EAccidentalSymbols.DOUBLE_FLAT, EAccidentalSymbols.FLAT),
    Cbm (EDiatonicPitches.C, EAccidentalSymbols.FLAT, EModes.minor, 3, EAccidentalSymbols.DOUBLE_FLAT, EAccidentalSymbols.FLAT),
    AbbM (EDiatonicPitches.A, EAccidentalSymbols.DOUBLE_FLAT, EModes.major, 4, EAccidentalSymbols.DOUBLE_FLAT, EAccidentalSymbols.FLAT),
    Fbm (EDiatonicPitches.F, EAccidentalSymbols.FLAT, EModes.minor, 4, EAccidentalSymbols.DOUBLE_FLAT, EAccidentalSymbols.FLAT),
    DbbM (EDiatonicPitches.D, EAccidentalSymbols.DOUBLE_FLAT, EModes.major, 5, EAccidentalSymbols.DOUBLE_FLAT, EAccidentalSymbols.FLAT),
    Bbbm (EDiatonicPitches.B, EAccidentalSymbols.DOUBLE_FLAT, EModes.minor, 5, EAccidentalSymbols.DOUBLE_FLAT, EAccidentalSymbols.FLAT),
    GbbM (EDiatonicPitches.G, EAccidentalSymbols.DOUBLE_FLAT, EModes.major, 6, EAccidentalSymbols.DOUBLE_FLAT, EAccidentalSymbols.FLAT),
    Ebbm (EDiatonicPitches.E, EAccidentalSymbols.DOUBLE_FLAT, EModes.minor, 6, EAccidentalSymbols.DOUBLE_FLAT, EAccidentalSymbols.FLAT),
    CbbM (EDiatonicPitches.C, EAccidentalSymbols.DOUBLE_FLAT, EModes.major, 7, EAccidentalSymbols.DOUBLE_FLAT, EAccidentalSymbols.FLAT),
    Abbm (EDiatonicPitches.A, EAccidentalSymbols.DOUBLE_FLAT, EModes.minor, 7, EAccidentalSymbols.DOUBLE_FLAT, EAccidentalSymbols.FLAT);

    private final EDiatonicPitches diatonicPitch;
    private final Optional<EAccidentalSymbols> accidentalSymbol;
    private final EModes mode;
    private final int firstAlterationCount;
    private final EAccidentalSymbols keySignatureFirstAccidental;
    private final Optional<EAccidentalSymbols> keySignatureSecondAccidental;

    private final Set<Pair<EDiatonicPitches, EAccidentalSymbols>> pitchClasses;

    private ETheoreticalKeys(EDiatonicPitches diatonicPitch, EAccidentalSymbols accidentalSymbol, EModes mode, int firstAlterationCount, EAccidentalSymbols keySignatureFirstAccidental, EAccidentalSymbols keySignatureSecondAccidental) {
        this.diatonicPitch = diatonicPitch;
        this.accidentalSymbol = Optional.ofNullable(accidentalSymbol);
        this.mode = mode;
        this.firstAlterationCount = firstAlterationCount;
        this.keySignatureFirstAccidental = keySignatureFirstAccidental;
        this.keySignatureSecondAccidental = Optional.ofNullable(keySignatureSecondAccidental);
        pitchClasses = new HashSet<>();
        fillPitchClasses();
    }

    /**
     * Order of sharp alterations F, C, G, D, A, E, B
     */
    public static final EDiatonicPitches KEY_SIGNATURE_STAFF_SHARPS[] = { EDiatonicPitches.F, EDiatonicPitches.C, EDiatonicPitches.G, EDiatonicPitches.D,
            EDiatonicPitches.A, EDiatonicPitches.E, EDiatonicPitches.B };

    private void fillPitchClasses() {
        EDiatonicPitches [] circle;
        if (keySignatureFirstAccidental == EAccidentalSymbols.FLAT || keySignatureFirstAccidental == EAccidentalSymbols.DOUBLE_FLAT) {
            circle = ICircleOfFifths.KEY_SIGNATURE_STAFF_FLATS;
        } else if (keySignatureFirstAccidental == EAccidentalSymbols.SHARP || keySignatureFirstAccidental == EAccidentalSymbols.DOUBLE_SHARP) {
            circle = ICircleOfFifths.KEY_SIGNATURE_STAFF_SHARPS;
        } else {
            throw new IMRuntimeException("Cannot build pitches with this accidental: " + keySignatureFirstAccidental);
        }

        int i = 0;
        while (i<firstAlterationCount) {
            EDiatonicPitches diatonicPitch = circle[i];
            Pair<EDiatonicPitches, EAccidentalSymbols> pair = Pair.of(diatonicPitch, keySignatureFirstAccidental);
            pitchClasses.add(pair);
            i++;
        }

        while (i<circle.length) {
            EDiatonicPitches diatonicPitch = circle[i];
            Pair<EDiatonicPitches, EAccidentalSymbols> pair = Pair.of(diatonicPitch, keySignatureSecondAccidental.get());
            pitchClasses.add(pair);
            i++;
        }
    }

    /**
     * Find a theoretical key with the given pitch classes
     * @param mode
     * @param pitchClassesParam
     * @return
     */
    public static Optional<ETheoreticalKeys> find(EModes mode, Collection<IPitchClass> pitchClassesParam) throws IMException {
        HashSet<Pair<EDiatonicPitches, EAccidentalSymbols>>  setParam = new HashSet<>();
        for (IPitchClass pitchClass: pitchClassesParam) {
            if (!pitchClass.getAccidental().isPresent()) {
                throw new IMException("Cannot find a pitch collection where there is a pitch class without an accidental");
            }
            setParam.add(Pair.of(
                    pitchClass.getDiatonicPitch().getValue(),
                    pitchClass.getAccidental().get().getValue()
            ));
        }

        for (ETheoreticalKeys theoreticalKey: ETheoreticalKeys.values()) {
            if (theoreticalKey.getMode() == mode && theoreticalKey.pitchClasses.equals(setParam)) {
                return Optional.of(theoreticalKey);
            }
        }

        return Optional.empty();
    }

    @Override
    public EDiatonicPitches getDiatonicPitch() {
        return diatonicPitch;
    }

    @Override
    public Optional<EAccidentalSymbols> getPitchAccidentalSymbol() {
        return accidentalSymbol;
    }

    @Override
    public EModes getMode() {
        return mode;
    }

    public int getFirstAlterationCount() {
        return firstAlterationCount;
    }

    public EAccidentalSymbols getKeySignatureFirstAccidental() {
        return keySignatureFirstAccidental;
    }

    public Optional<EAccidentalSymbols> getKeySignatureSecondAccidental() {
        return keySignatureSecondAccidental;
    }
}
