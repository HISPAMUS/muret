package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.properties.IDots;
import es.ua.dlsi.grfia.moosicae.core.IDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.properties.IFigure;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public abstract class IDurationalSingleBuilder<T extends IDurationalSingle> extends CoreObjectBuilder<T> {
    protected IFigure figure;
    protected IDots dots;

    public IDurationalSingleBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IDurationalSingleBuilder<T> from(IFigure figure) {
        this.figure = figure;
        return this;
    }

    public IDurationalSingleBuilder<T> from(IDots dots) {
        this.dots = dots;
        return this;
    }

    public IDurationalSingleBuilder<T> from(EFigures figure) {
        this.figure = coreObjectFactory.createFigure(getId(), figure);
        return this;
    }

    public IDurationalSingleBuilder<T> from(int ndots) {
        if (ndots > 0) {
            this.dots = coreObjectFactory.createDots(getId(), ndots);
        }
        return this;
    }
}
