package es.ua.dlsi.grfia.moosicae.core.enums;

import es.ua.dlsi.grfia.moosicae.IMException;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Common keys that have the same accidental in the key signature. Keys such as G#M that contain a double sharp and several sharps
 * are to be encoded using EMixedAlterationKeys
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public enum EConventionalKeys implements IKeyEnum {
    CM (EDiatonicPitches.C, null, EModes.major, 0, null),
    Am (EDiatonicPitches.A, null, EModes.minor, 0, null),
    GM (EDiatonicPitches.G, null, EModes.major, 1, EAccidentalSymbols.SHARP),
    Em (EDiatonicPitches.E, null, EModes.minor, 1, EAccidentalSymbols.SHARP),
    DM (EDiatonicPitches.D, null, EModes.major, 2, EAccidentalSymbols.SHARP),
    Bm (EDiatonicPitches.B, null, EModes.minor, 2, EAccidentalSymbols.SHARP),
    AM (EDiatonicPitches.A, null, EModes.major, 3, EAccidentalSymbols.SHARP),
    Fsm (EDiatonicPitches.F, EAccidentalSymbols.SHARP, EModes.minor, 3, EAccidentalSymbols.SHARP),
    EM (EDiatonicPitches.E, null, EModes.major, 4, EAccidentalSymbols.SHARP),
    Csm (EDiatonicPitches.C, EAccidentalSymbols.SHARP, EModes.minor, 4, EAccidentalSymbols.SHARP),
    BM (EDiatonicPitches.B, null, EModes.major, 5, EAccidentalSymbols.SHARP),
    Gsm (EDiatonicPitches.G, EAccidentalSymbols.SHARP, EModes.minor, 5, EAccidentalSymbols.SHARP),
    FsM (EDiatonicPitches.F, EAccidentalSymbols.SHARP, EModes.major, 6, EAccidentalSymbols.SHARP),
    Dsm (EDiatonicPitches.D, EAccidentalSymbols.SHARP, EModes.minor, 6, EAccidentalSymbols.SHARP),
    CsM (EDiatonicPitches.C, EAccidentalSymbols.SHARP, EModes.major, 7, EAccidentalSymbols.SHARP),
    Asm (EDiatonicPitches.A, EAccidentalSymbols.SHARP, EModes.minor, 7  , EAccidentalSymbols.SHARP),
    FM (EDiatonicPitches.F, null, EModes.major, 1, EAccidentalSymbols.FLAT),
    Dm (EDiatonicPitches.D, null, EModes.minor, 1, EAccidentalSymbols.FLAT),
    BbM (EDiatonicPitches.B, EAccidentalSymbols.FLAT, EModes.major, 2, EAccidentalSymbols.FLAT),
    Gm (EDiatonicPitches.G, null, EModes.minor, 2, EAccidentalSymbols.FLAT),
    EbM (EDiatonicPitches.E, EAccidentalSymbols.FLAT, EModes.major, 3, EAccidentalSymbols.FLAT),
    Cm (EDiatonicPitches.C, null, EModes.minor, 3, EAccidentalSymbols.FLAT),
    AbM (EDiatonicPitches.A, EAccidentalSymbols.FLAT, EModes.major, 4, EAccidentalSymbols.FLAT),
    Fm (EDiatonicPitches.F, null, EModes.minor, 4, EAccidentalSymbols.FLAT),
    DbM (EDiatonicPitches.D, EAccidentalSymbols.FLAT, EModes.major, 5, EAccidentalSymbols.FLAT),
    Bbm (EDiatonicPitches.B, EAccidentalSymbols.FLAT, EModes.minor, 5, EAccidentalSymbols.FLAT),
    GbM (EDiatonicPitches.G, EAccidentalSymbols.FLAT, EModes.major, 6, EAccidentalSymbols.FLAT),
    Ebm (EDiatonicPitches.E, EAccidentalSymbols.FLAT, EModes.minor, 6, EAccidentalSymbols.FLAT),
    CbM (EDiatonicPitches.C, EAccidentalSymbols.FLAT, EModes.major, 7, EAccidentalSymbols.FLAT),
    Abm (EDiatonicPitches.A, EAccidentalSymbols.FLAT, EModes.minor, 7, EAccidentalSymbols.FLAT);


    private final EDiatonicPitches diatonicPitch;
    private final Optional<EAccidentalSymbols> pitchAccidentalSymbol;
    private final EModes mode;
    private final int keySignatureAccidentalCount;
    private final Optional<EAccidentalSymbols> keySignatureAccidental;

    private EConventionalKeys(EDiatonicPitches diatonicPitch, EAccidentalSymbols pitchAccidentalSymbol, EModes mode, int keySignatureAccidentals, EAccidentalSymbols keySignatureAccidental) {
        this.diatonicPitch = diatonicPitch;
        this.pitchAccidentalSymbol = Optional.ofNullable(pitchAccidentalSymbol);
        this.mode = mode;
        this.keySignatureAccidentalCount = keySignatureAccidentals;
        this.keySignatureAccidental = Optional.ofNullable(keySignatureAccidental);
    }

    @Override
    public EDiatonicPitches getDiatonicPitch() {
        return diatonicPitch;
    }

    @Override
    public Optional<EAccidentalSymbols> getPitchAccidentalSymbol() {
        return pitchAccidentalSymbol;
    }

    @Override
    public EModes getMode() {
        return mode;
    }

    public int getKeySignatureAccidentalCount() {
        return keySignatureAccidentalCount;
    }

    public Optional<EAccidentalSymbols> getKeySignatureAccidental() {
        return keySignatureAccidental;
    }

    public static EConventionalKeys findKeyWithAccidentalCount(@NotNull EModes mode, @NotNull Integer keySignatureAccidentalCount, EAccidentalSymbols accidentalSymbol) throws IMException {
        if (keySignatureAccidentalCount == 0) {
            if (mode == EModes.major) {
                return CM;
            } else {
                return Am;
            }
        } else {
            for (EConventionalKeys key : EConventionalKeys.values()) {
                if (key.getKeySignatureAccidentalCount() == keySignatureAccidentalCount && key.getMode() == mode && accidentalSymbol == key.getKeySignatureAccidental().get()) {
                    return key;
                }
            }
            throw new IMException("Cannot find a key with " + keySignatureAccidentalCount + " "  + accidentalSymbol + "s and mode " + mode);
        }
    }
}
