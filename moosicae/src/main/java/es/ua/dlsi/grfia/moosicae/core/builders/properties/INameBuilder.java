package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.properties.IName;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class INameBuilder extends IStringPropertyBuilder<IName> {

    public INameBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public IName build() throws IMException {
        return coreObjectFactory.createName(getId(), value);
    }

}
