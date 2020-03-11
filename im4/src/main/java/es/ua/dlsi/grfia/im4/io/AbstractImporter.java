package es.ua.dlsi.grfia.im4.io;

import es.ua.dlsi.grfia.im4.core.ICoreAbstractFactory;

public abstract class AbstractImporter implements IImporter {
    protected final ICoreAbstractFactory coreAbstractFactory;

    protected AbstractImporter(ICoreAbstractFactory coreAbstractFactory) {
        this.coreAbstractFactory = coreAbstractFactory;
    }
}
