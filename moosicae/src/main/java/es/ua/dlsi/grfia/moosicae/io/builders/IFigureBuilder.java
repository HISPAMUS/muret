package es.ua.dlsi.grfia.moosicae.io.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IFigure;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IFigureBuilder extends CoreObjectBuilder<IFigure>  {
    private EFigures figure;

    public IFigureBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setFigure(EFigures figure) {
        this.figure = figure;
    }

    @Override
    public IFigure build() throws IMException {
        assertRequired("figure", figure);
        return coreObjectFactory.createFigure(figure);
    }
}
