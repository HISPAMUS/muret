package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.utils.Time;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class Durational extends CoreItem implements IDurational {
    @NotNull
    private final Time duration;

    protected Durational(IId id, @NotNull Time duration) {
        super(id);
        this.duration = duration;
    }

    @Override
    public Time getDuration() {
        return duration;
    }

    public abstract Durational clone();

    @Override
    public IId getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Durational)) return false;

        Durational that = (Durational) o;

        return duration.equals(that.duration);
    }

    @Override
    public int hashCode() {
        return duration.hashCode();
    }
}
