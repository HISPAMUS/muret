package es.ua.dlsi.grfia.moosicae.core;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class PitchClass implements IPitchClass {
    private final EDiatonicPitches diatonicPitch;
    private final Optional<EAccidentals> accidental;

    public PitchClass(EDiatonicPitches diatonicPitch, Optional<EAccidentals> accidental) {
        this.diatonicPitch = diatonicPitch;
        this.accidental = accidental;
    }

    @Override
    public EDiatonicPitches getDiatonicPitch() {
        return diatonicPitch;
    }

    @Override
    public Optional<EAccidentals> getAccidental() {
        return accidental;
    }
}
