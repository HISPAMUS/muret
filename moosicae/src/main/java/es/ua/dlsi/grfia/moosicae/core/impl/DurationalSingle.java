package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.properties.IDots;
import es.ua.dlsi.grfia.moosicae.core.IDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.properties.IFigure;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;


import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class DurationalSingle extends Durational implements IDurationalSingle {
    @NotNull
    protected final IFigure figure;

    protected final IDots dots;

    public DurationalSingle(IId id, @NotNull IFigure figure,  IDots dots) {
        super(id, figure.getDurationWithDots(dots != null ? dots.getValue() : 0));
        this.figure = figure;
        this.dots = dots;
    }

    @Override
    public IFigure getFigure() {
        return figure;
    }

    @Override
    public Optional<IDots> getDots() {
        return Optional.ofNullable(dots);
    }

    public abstract DurationalSingle clone();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DurationalSingle)) return false;
        if (!super.equals(o)) return false;

        DurationalSingle that = (DurationalSingle) o;

        if (!figure.equals(that.figure)) return false;
        return dots != null ? dots.equals(that.dots) : that.dots == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + figure.hashCode();
        result = 31 * result + (dots != null ? dots.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DurationalSingle{" +
                "figure=" + figure +
                ", dots=" + dots +
                "} " + super.toString();
    }
}
