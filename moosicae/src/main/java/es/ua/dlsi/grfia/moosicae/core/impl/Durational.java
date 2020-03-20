package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.utils.Time;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class Durational implements IDurational {
    private final Time duration;

    protected Durational(Time duration) {
        this.duration = duration;
    }

    @Override
    public Time getDuration() {
        return duration;
    }

    public abstract Durational clone();


}
