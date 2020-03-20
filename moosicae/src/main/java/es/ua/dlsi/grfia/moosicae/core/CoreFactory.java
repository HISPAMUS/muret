package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.impl.CoreAbstractFactoryImpl;

/**
 * It creates the core abstract factory
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class CoreFactory {
    /**
     * It returns the default implementation of the core abstract factory
     * @return
     */
    public ICoreAbstractFactory create() {
        return new CoreAbstractFactoryImpl();
    }
}
