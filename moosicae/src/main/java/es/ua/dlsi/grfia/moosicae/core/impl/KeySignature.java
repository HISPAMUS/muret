package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;
import javax.validation.constraints.NotNull;

import java.util.Arrays;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class KeySignature extends CoreItem implements IKeySignature {
    @NotNull
    private final IPitchClass[] pitchClasses;

    /**
     * Created by factories
     * @param pitchClasses
     */
    KeySignature(IId id, @NotNull IPitchClass[] pitchClasses) {
        super(id);
        this.pitchClasses = pitchClasses.clone();
    }

    @Override
    public IPitchClass[] getPitchClasses() {
        return pitchClasses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeySignature)) return false;

        KeySignature that = (KeySignature) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(pitchClasses, that.pitchClasses);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pitchClasses);
    }

    @Override
    public String toString() {
        return "KeySignature{" +
                "pitchClasses=" + Arrays.toString(pitchClasses) +
                '}';
    }
}
