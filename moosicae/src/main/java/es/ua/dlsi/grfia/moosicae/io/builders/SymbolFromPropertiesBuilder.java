package es.ua.dlsi.grfia.moosicae.io.builders;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ISymbol;
import es.ua.dlsi.grfia.moosicae.utils.builder.AbstractBuilderFromProperties;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class SymbolFromPropertiesBuilder<SymbolType extends ISymbol> extends AbstractBuilderFromProperties<SymbolType> {
    protected final ICoreAbstractFactory coreSymbolFactory;

    protected SymbolFromPropertiesBuilder(ICoreAbstractFactory coreSymbolFactory) {
        this.coreSymbolFactory = coreSymbolFactory;
    }
}
