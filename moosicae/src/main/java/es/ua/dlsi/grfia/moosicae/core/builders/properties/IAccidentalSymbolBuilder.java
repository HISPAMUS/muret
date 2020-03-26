package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.properties.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IAccidentalSymbolBuilder extends CoreObjectBuilder<IAccidentalSymbol> {
    private EAccidentalSymbols value;

    public IAccidentalSymbolBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IAccidentalSymbolBuilder from(EAccidentalSymbols value) {
        this.value = value;
        return this;
    }

    @Override
    public IAccidentalSymbol build() throws IMException {
        return coreObjectFactory.createAccidentalSymbol(getId(), value);
    }

}
