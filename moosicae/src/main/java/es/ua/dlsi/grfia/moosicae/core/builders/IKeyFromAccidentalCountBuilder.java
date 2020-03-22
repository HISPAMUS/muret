package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IKeyFromAccidentalCountBuilder extends CoreObjectBuilder<IKey> {
    private IAccidentalSymbol accidentalSymbol;
    private IKeyAccidentalCount accidentalCount;
    private IMode mode;

    public IKeyFromAccidentalCountBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setAccidentalSymbol(IAccidentalSymbol accidentalSymbol) {
        this.accidentalSymbol = accidentalSymbol;
    }

    public void setAccidentalCount(IKeyAccidentalCount accidentalCount) {
        this.accidentalCount = accidentalCount;
    }

    public void setMode(IMode mode) {
        this.mode = mode;
    }

    @Override
    public IKey build() throws IMException {
        assertRequired("accidentalSymbol", accidentalSymbol);
        assertRequired("accidentalCount", accidentalCount);
        assertRequired("mode", mode);
        return coreObjectFactory.createKey(getId(), accidentalCount, accidentalSymbol, mode);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importKeyFromAccidentalCount(this, inputOutputType);
    }
}
