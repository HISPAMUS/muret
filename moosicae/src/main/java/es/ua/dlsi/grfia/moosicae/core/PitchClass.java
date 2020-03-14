package es.ua.dlsi.grfia.moosicae.core;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class PitchClass implements IPitchClass {
    private final EDiatonicPitches diatonicPitch;
    private final EAccidentals accidental;

    public PitchClass(EDiatonicPitches diatonicPitch, EAccidentals accidental) {
        this.diatonicPitch = diatonicPitch;
        this.accidental = accidental;
    }

    @Override
    public EDiatonicPitches getDiatonicPitch() {
        return diatonicPitch;
    }

    @Override
    public EAccidentals getAccidental() {
        return accidental;
    }
}
