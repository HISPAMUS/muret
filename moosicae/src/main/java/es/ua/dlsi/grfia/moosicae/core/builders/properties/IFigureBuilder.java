package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.core.properties.IFigure;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IFigureBuilder extends CoreObjectBuilder<IFigure> {
    private EFigures value;

    public IFigureBuilder() {}

    public IFigureBuilder from(EFigures value) {
        this.value = value;
        return this;
    }

    @Override
    public IFigure build() throws IMException {
        return ICoreAbstractFactory.getInstance().createFigure(getId(), value);
    }


}
