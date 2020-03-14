package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDots;

import java.util.Objects;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Dots implements IDots {
    private final int count;

    Dots(int count) {
        this.count = count;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Dots clone() {
        return new Dots(count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dots dots = (Dots) o;
        return count == dots.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return "Dots{" +
                "count=" + count +
                '}';
    }
}
