package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.Objects;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class Pitch implements IPitch {
    private final IOctave octave;
    private final Optional<IAlteration> alteration;
    private final IDiatonicPitch diatonicPitch;

    public Pitch(IOctave octave, Optional<IAlteration> alteration, IDiatonicPitch diatonicPitch) {
        this.octave = octave;
        this.alteration = alteration;
        this.diatonicPitch = diatonicPitch;
    }

    @Override
    public IOctave getOctave() {
        return octave;
    }

    @Override
    public Optional<IAlteration> getAlteration() {
        return alteration;
    }

    @Override
    public IDiatonicPitch getDiatonicPitch() {
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
