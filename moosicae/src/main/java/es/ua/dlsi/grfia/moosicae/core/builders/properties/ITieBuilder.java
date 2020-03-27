package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.ITie;
import es.ua.dlsi.grfia.moosicae.core.properties.ITieOrientation;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class ITieBuilder extends CoreObjectBuilder<ITie> {
    private ITieOrientation tieOrientation;

    public ITieBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public ITieBuilder from(ITieOrientation value) {
        this.tieOrientation = value;
        return this;
    }

    @Override
    public ITie build() throws IMException {
        return coreObjectFactory.createTie(getId(), tieOrientation);
    }

}
