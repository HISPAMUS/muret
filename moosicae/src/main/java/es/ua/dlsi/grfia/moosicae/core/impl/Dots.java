package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDots;
import es.ua.dlsi.grfia.moosicae.core.IId;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Dots extends CoreProperty implements IDots {
    @NotNull
    private final Integer count;

    Dots(@NotNull IId id, @NotNull Integer count) {
        super(id);
        this.count = count;
    }

    @Override
    public Integer getCount() {
        return count;
    }

    @Override
    public Dots clone() {
        return new Dots(IdGenerator.getInstance().generateUniqueId(), count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dots)) return false;

        Dots dots = (Dots) o;

        return count.equals(dots.count);
    }

    @Override
    public int hashCode() {
        return count.hashCode();
    }

    @Override
    public String toString() {
        return "Dots{" +
                "count=" + count +
                '}';
    }
}
