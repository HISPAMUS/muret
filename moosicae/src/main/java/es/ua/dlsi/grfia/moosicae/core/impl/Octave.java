package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.IOctave;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class Octave extends CoreProperty implements IOctave {
    @NotNull
    private final Integer number;

    public Octave(@NotNull IId id, @NotNull Integer number) {
        super(id);
        this.number = number;
    }

    @Override
    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Octave)) return false;

        Octave octave = (Octave) o;

        return number.equals(octave.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public Octave clone() {
        return new Octave(IdGenerator.getInstance().generateUniqueId(), number);
    }

    @Override
    public String toString() {
        return "Octave{" +
                "number=" + number +
                '}';
    }
}
