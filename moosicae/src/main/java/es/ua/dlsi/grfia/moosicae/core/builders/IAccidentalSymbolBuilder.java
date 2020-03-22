package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IAccidentalCore;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IAccidentalSymbolBuilder extends CoreObjectBuilder<IAccidentalCore>  {
    private EAccidentalSymbols accidentalSymbol;

    public IAccidentalSymbolBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setAccidentalSymbol(EAccidentalSymbols accidentalSymbol) {
        this.accidentalSymbol = accidentalSymbol;
    }

    @Override
    public IAccidentalCore build() throws IMException {
        assertRequired("accidentalSymbol", accidentalSymbol);
        return coreObjectFactory.createAccidentalSymbol(getId(), accidentalSymbol);
    }
}
