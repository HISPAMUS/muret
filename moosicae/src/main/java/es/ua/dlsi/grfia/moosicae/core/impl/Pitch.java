package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.impl.properties.CoreProperty;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import javax.validation.constraints.NotNull;


import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class Pitch extends CoreProperty implements IPitch {
    @NotNull
    private final IOctave octave;

    private final IAlteration alteration;
    @NotNull
    private final IDiatonicPitch diatonicPitch;

    public Pitch(@NotNull IId id, @NotNull IOctave octave,  IAlteration alteration, @NotNull IDiatonicPitch diatonicPitch) {
        super(id);
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
        return Optional.ofNullable(alteration);
    }

    @Override
    public IDiatonicPitch getDiatonicPitch() {
        return diatonicPitch;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pitch)) return false;

        Pitch pitch = (Pitch) o;

        if (!octave.equals(pitch.octave)) return false;
        if (alteration != null ? !alteration.equals(pitch.alteration) : pitch.alteration != null) return false;
        return diatonicPitch.equals(pitch.diatonicPitch);
    }

    @Override
    public int hashCode() {
        int result = octave.hashCode();
        result = 31 * result + (alteration != null ? alteration.hashCode() : 0);
        result = 31 * result + diatonicPitch.hashCode();
        return result;
    }

    @Override
    public Pitch clone() {
        return new Pitch(IdGenerator.getInstance().generateUniqueId(), octave, alteration, diatonicPitch);
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
