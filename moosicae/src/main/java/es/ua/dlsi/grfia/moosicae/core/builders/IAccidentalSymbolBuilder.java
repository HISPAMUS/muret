package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IAccidentalSymbolBuilder extends CoreObjectBuilder<IAccidentalSymbol>  {
    private EAccidentalSymbols accidentalSymbol;

    public IAccidentalSymbolBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setAccidentalSymbol(EAccidentalSymbols accidentalSymbol) {
        this.accidentalSymbol = accidentalSymbol;
    }

    @Override
    public IAccidentalSymbol build() throws IMException {
        assertRequired("accidentalSymbol", accidentalSymbol);
        return coreObjectFactory.createAccidentalSymbol(getId(), accidentalSymbol);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importAccidentalSymbol(this, inputOutputType);
    }
}
