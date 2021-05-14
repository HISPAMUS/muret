package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IPitchedDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.adt.ITime;
import es.ua.dlsi.grfia.moosicae.core.properties.IDots;
import es.ua.dlsi.grfia.moosicae.core.properties.IFigure;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 13/5/21
 */
public abstract class PitchedAbstractDecorator implements IPitchedDurationalSingle {
    protected final IPitchedDurationalSingle decoratesTo;

    public PitchedAbstractDecorator(IPitchedDurationalSingle pitchedDurationalSingle) {
        this.decoratesTo = pitchedDurationalSingle;
    }

    public ITime getDuration() {
        return decoratesTo.getDuration();
    }

    public IFigure getFigure() {
        return decoratesTo.getFigure();
    }

    public Optional<IDots> getDots() {
        return decoratesTo.getDots();
    }

    public IId getId() {
        return decoratesTo.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PitchedAbstractDecorator)) return false;

        PitchedAbstractDecorator that = (PitchedAbstractDecorator) o;

        return decoratesTo.equals(that.decoratesTo);
    }

    public IPitchedDurationalSingle getDecoratesTo() {
        return decoratesTo;
    }

    @Override
    public int hashCode() {
        return decoratesTo.hashCode();
    }

    @Override
    public abstract PitchedAbstractDecorator clone();
}
