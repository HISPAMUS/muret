package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IOctave;

import java.util.Objects;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class Octave implements IOctave {
    private final int number;

    public Octave(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Octave octave = (Octave) o;
        return number == octave.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public Octave clone() {
        return new Octave(number);
    }

    @Override
    public String toString() {
        return "Octave{" +
                "number=" + number +
                '}';
    }
}
