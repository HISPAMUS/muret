package es.ua.dlsi.grfia.moosicae.core.enums;

import java.util.Optional;

/**
 * Keys that have the two different kinds of accidental in the key signature. There are always 7 alterations
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public enum EMixedAlterationKeys {
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

    private EMixedAlterationKeys(EDiatonicPitches diatonicPitch, EAccidentalSymbols accidentalSymbol, EModes mode, int firstAlterationCount, EAccidentalSymbols keySignatureFirstAccidental, EAccidentalSymbols keySignatureSecondAccidental) {
        this.diatonicPitch = diatonicPitch;
        this.accidentalSymbol = Optional.ofNullable(accidentalSymbol);
        this.mode = mode;
        this.firstAlterationCount = firstAlterationCount;
        this.keySignatureFirstAccidental = keySignatureFirstAccidental;
        this.keySignatureSecondAccidental = Optional.ofNullable(keySignatureSecondAccidental);
    }

    public EDiatonicPitches getDiatonicPitch() {
        return diatonicPitch;
    }

    public Optional<EAccidentalSymbols> getAccidentalSymbol() {
        return accidentalSymbol;
    }

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
