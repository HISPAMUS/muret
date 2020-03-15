package es.ua.dlsi.grfia.moosicae.io.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeterSymbol;
import es.ua.dlsi.grfia.moosicae.core.enums.EMeterSymbols;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IMeterSymbolBuilder extends CoreObjectBuilder<IMeterSymbol>  {
    private EMeterSymbols meterSymbols;

    public IMeterSymbolBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setMeterSymbols(EMeterSymbols meterSymbols) {
        this.meterSymbols = meterSymbols;
    }

    @Override
    public IMeterSymbol build() throws IMException {
        assertRequired("meterSymbols", meterSymbols);
        return coreObjectFactory.createMeterSymbol(meterSymbols);
    }
}
