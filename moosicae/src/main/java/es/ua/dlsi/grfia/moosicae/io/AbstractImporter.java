package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.core.CoreFactory;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.io.builders.BuilderFactory;

public abstract class AbstractImporter implements IImporter {
    protected final ICoreAbstractFactory coreAbstractFactory;
    protected final BuilderFactory builderFactory;

    protected AbstractImporter(ICoreAbstractFactory coreAbstractFactory) {
        this.coreAbstractFactory = coreAbstractFactory;
        this.builderFactory = new BuilderFactory(this.coreAbstractFactory);
    }

    /**
     * It uses the default factory
     */
    protected AbstractImporter() {
        this.coreAbstractFactory = new CoreFactory().create();
        this.builderFactory = new BuilderFactory(this.coreAbstractFactory);
    }

}
