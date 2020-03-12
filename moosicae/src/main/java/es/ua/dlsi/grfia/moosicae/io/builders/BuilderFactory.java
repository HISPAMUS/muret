package es.ua.dlsi.grfia.moosicae.io.builders;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;

public class BuilderFactory {
    private final IClefBuilder iClefBuilder;

    public BuilderFactory(ICoreAbstractFactory coreSymbolFactory) {
        iClefBuilder = new IClefBuilder(coreSymbolFactory);
    }

    public IClefBuilder getClefBuilder() {
        return iClefBuilder;

    }
}
