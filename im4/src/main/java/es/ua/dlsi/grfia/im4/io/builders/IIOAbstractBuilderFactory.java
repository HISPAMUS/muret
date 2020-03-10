package es.ua.dlsi.grfia.im4.io.builders;

import es.ua.dlsi.grfia.im4.core.IClef;
import es.ua.dlsi.grfia.im4.core.IMeter;

public interface IIOAbstractBuilderFactory {
    public abstract ISymbolBuilder<IClef> getClefBuilder();
    public abstract ISymbolBuilder<IMeter> getMeterBuilder();
}
