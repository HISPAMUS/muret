package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.impl.CoreAbstractFactoryImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

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
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Creating core factory {0}", 12);
        return new CoreAbstractFactoryImpl();
    }
}
