package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.IDiatonicPitch;
import es.ua.dlsi.grfia.moosicae.core.IPitchClass;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class PitchClass implements IPitchClass {
    private final IDiatonicPitch diatonicPitch;
    private final Optional<IAccidentalSymbol> accidental;

    public PitchClass(IDiatonicPitch diatonicPitch, Optional<IAccidentalSymbol> accidental) {
        this.diatonicPitch = diatonicPitch;
        this.accidental = accidental;
    }

    @Override
    public IDiatonicPitch getDiatonicPitch() {
        return diatonicPitch;
    }

    @Override
    public Optional<IAccidentalSymbol> getAccidental() {
        return accidental;
    }

    @Override
    public PitchClass clone() {
        return new PitchClass(diatonicPitch, accidental);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PitchClass)) return false;

        PitchClass that = (PitchClass) o;

        if (!diatonicPitch.equals(that.diatonicPitch)) return false;
        return accidental.equals(that.accidental);
    }

    @Override
    public int hashCode() {
        int result = diatonicPitch.hashCode();
        result = 31 * result + accidental.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PitchClass{" +
                "diatonicPitch=" + diatonicPitch +
                ", accidental=" + accidental +
                '}';
    }
}
