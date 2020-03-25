package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ISystem;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public abstract class ISystemBuilder<T extends ISystem> extends CoreObjectBuilder<T> {
    public ISystemBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }
}
