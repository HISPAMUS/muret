package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDots;
import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.core.EFigures;
import es.ua.dlsi.grfia.moosicae.utils.CoreUtils;
import es.ua.dlsi.grfia.moosicae.utils.Time;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class Durational implements IDurational {
    private final EFigures figure;
    private final Optional<IDots> dots;
    private final Time duration;

    protected Durational(EFigures figure, IDots dots) {
        CoreUtils.requireNotNullConstructorParam(this, figure, "figure");
        this.figure = figure;
        this.dots = Optional.ofNullable(dots);

        int ndots = dots == null ? 0: dots.getCount();
        this.duration = figure.getDurationWithDots(ndots);
    }

    @Override
    public Time getDuration() {
        return duration;
    }

    public abstract Durational clone();
}
