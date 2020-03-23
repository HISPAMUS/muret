package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeterSymbol;
import es.ua.dlsi.grfia.moosicae.core.enums.EMeterSymbols;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IMeterSymbolBuilder extends CoreObjectBuilder<IMeterSymbol> {
    private EMeterSymbols meterSymbol;
    public IMeterSymbolBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IMeterSymbolBuilder from(EMeterSymbols meterSymbol) {
        this.meterSymbol = meterSymbol;
        return this;
    }
    @Override
    public IMeterSymbol build() throws IMException {
        return coreObjectFactory.createMeterSymbol(getId(), meterSymbol);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importMeterSymbol(this, inputOutputType);
    }
}
