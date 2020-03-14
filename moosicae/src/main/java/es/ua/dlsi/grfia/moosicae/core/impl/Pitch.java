package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.utils.CoreUtils;

import java.util.Objects;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class Pitch implements IPitch {
    private final IOctave octave;
    private final IAlteration alteration;
    private final EDiatonicPitches diatonicPitch;

    public Pitch(IOctave octave, IAlteration alteration, EDiatonicPitches diatonicPitch) {
        CoreUtils.requireNotNullConstructorParam(this, octave, "octave");
        CoreUtils.requireNotNullConstructorParam(this, diatonicPitch, "diatonicPitch");
        this.octave = octave;
        this.alteration = alteration;
        this.diatonicPitch = diatonicPitch;
    }

    @Override
    public IOctave getOctave() {
        return octave;
    }

    @Override
    public IAlteration getAlteration() {
        return alteration;
    }

    @Override
    public EDiatonicPitches getDiatonicPitch() {
        return diatonicPitch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pitch pitch = (Pitch) o;
        return octave.equals(pitch.octave) &&
                alteration.equals(pitch.alteration) &&
                diatonicPitch == pitch.diatonicPitch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(octave, alteration, diatonicPitch);
    }

    @Override
    public Pitch clone() {
        return new Pitch(octave, alteration, diatonicPitch);
    }

    @Override
    public String toString() {
        return "Pitch{" +
                "octave=" + octave +
                ", alteration=" + alteration +
                ", diatonicPitch=" + diatonicPitch +
                '}';
    }
}
