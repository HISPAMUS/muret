package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDots;
import es.ua.dlsi.grfia.moosicae.core.IDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.IFigure;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class DurationalSingle extends Durational implements IDurationalSingle {
    protected final IFigure figure;
    protected final Optional<IDots> dots;

    public DurationalSingle(IFigure figure, Optional<IDots> dots) {
        super(figure.getDurationWithDots(dots.isPresent() ? dots.get().getCount() : 0));
        this.figure = figure;
        this.dots = dots;
    }

    @Override
    public IFigure getFigure() {
        return figure;
    }

    @Override
    public Optional<IDots> getDots() {
        return dots;
    }

    public abstract DurationalSingle clone();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DurationalSingle)) return false;

        DurationalSingle that = (DurationalSingle) o;

        if (figure != that.figure) return false;
        return dots.equals(that.dots);
    }

    @Override
    public int hashCode() {
        int result = figure.hashCode();
        result = 31 * result + dots.hashCode();
        return result;
    }
}
