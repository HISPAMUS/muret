package es.ua.dlsi.grfia.im4.io.skm;

import es.ua.dlsi.grfia.im4.core.IClef;
import es.ua.dlsi.grfia.im4.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.im4.core.IMeter;
import es.ua.dlsi.grfia.im4.io.builders.IIOAbstractBuilderFactory;
import es.ua.dlsi.grfia.im4.io.builders.ISymbolBuilder;
import es.ua.dlsi.grfia.im4.io.skm.builders.SkmClefBuilder;

public class SkmBuilderFactory implements IIOAbstractBuilderFactory {
    ISymbolBuilder<IClef> clefISymbolBuilder;

    public SkmBuilderFactory(ICoreAbstractFactory coreSymbolFactory) {
        clefISymbolBuilder = new SkmClefBuilder(coreSymbolFactory);
    }

    @Override
    public ISymbolBuilder<IClef> getClefBuilder() {
        return clefISymbolBuilder;
    }

    @Override
    public ISymbolBuilder<IMeter> getMeterBuilder() {
        return null;
    }
}
