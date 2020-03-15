package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.core.CoreFactory;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class AbstractImporter implements IImporter {
    protected final ICoreAbstractFactory coreAbstractFactory;

    protected AbstractImporter(ICoreAbstractFactory coreAbstractFactory) {
        this.coreAbstractFactory = coreAbstractFactory;
    }

    /**
     * It uses the default factory
     */
    protected AbstractImporter() {
        this.coreAbstractFactory = new CoreFactory().create();
    }

}
