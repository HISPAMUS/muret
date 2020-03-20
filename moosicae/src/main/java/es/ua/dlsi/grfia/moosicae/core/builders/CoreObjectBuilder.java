package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ICoreObject;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public abstract class CoreObjectBuilder<T extends ICoreObject> {
    protected final ICoreAbstractFactory coreObjectFactory;

    public CoreObjectBuilder(ICoreAbstractFactory coreObjectFactory) {
        this.coreObjectFactory = coreObjectFactory; 
    }

    public abstract T build() throws IMException;

    protected void assertRequired(String propertyName, Object property) throws IMException {
        // this could be used with reflection but this way is faster and easier
        if (property == null) {
            throw new IMException("Missing property '" + propertyName + "'");
        }
    }
}
