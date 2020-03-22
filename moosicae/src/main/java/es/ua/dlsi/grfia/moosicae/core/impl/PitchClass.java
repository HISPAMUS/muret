package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.IDiatonicPitch;
import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.IPitchClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class PitchClass extends CoreProperty implements IPitchClass {
    @NotNull
    private final IDiatonicPitch diatonicPitch;
    @Nullable
    private final IAccidentalSymbol accidental;

    public PitchClass(@NotNull IId id, @NotNull IDiatonicPitch diatonicPitch, @Nullable IAccidentalSymbol accidental) {
        super(id);
        this.diatonicPitch = diatonicPitch;
        this.accidental = accidental;
    }

    @Override
    public IDiatonicPitch getDiatonicPitch() {
        return diatonicPitch;
    }

    @Override
    public Optional<IAccidentalSymbol> getAccidental() {
        return Optional.ofNullable(accidental);
    }

    @Override
    public PitchClass clone() {
        return new PitchClass(IdGenerator.getInstance().generateUniqueId(), diatonicPitch, accidental);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PitchClass)) return false;

        PitchClass that = (PitchClass) o;

        if (!diatonicPitch.equals(that.diatonicPitch)) return false;
        return accidental != null ? accidental.equals(that.accidental) : that.accidental == null;
    }

    @Override
    public int hashCode() {
        int result = diatonicPitch.hashCode();
        result = 31 * result + (accidental != null ? accidental.hashCode() : 0);
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
