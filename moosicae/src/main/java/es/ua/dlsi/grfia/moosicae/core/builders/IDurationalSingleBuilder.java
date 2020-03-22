package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IDots;
import es.ua.dlsi.grfia.moosicae.core.IDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.IFigure;
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

    public void setFigure(IFigure figure) {
        this.figure = figure;
    }

    public void setDots(IDots dots) {
        this.dots = dots;
    }

    public void setFigure(EFigures figure) {
        this.figure = coreObjectFactory.createFigure(getId(), figure);
    }

    public void setDots(int ndots) {
        if (ndots > 0) {
            this.dots = coreObjectFactory.createDots(getId(), ndots);
        }
    }

    protected void assertRequired() throws IMException {
        assertRequired("figure", figure);
    }
}
