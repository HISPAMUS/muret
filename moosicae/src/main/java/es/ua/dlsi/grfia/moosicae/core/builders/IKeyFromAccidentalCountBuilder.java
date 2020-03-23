package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.properties.IKeyAccidentalCount;
import es.ua.dlsi.grfia.moosicae.core.properties.IMode;
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

    public IKeyFromAccidentalCountBuilder from(IAccidentalSymbol accidentalSymbol) {
        this.accidentalSymbol = accidentalSymbol;
        return this;
    }

    public IKeyFromAccidentalCountBuilder from(IKeyAccidentalCount accidentalCount) {
        this.accidentalCount = accidentalCount;
        return this;
    }

    public IKeyFromAccidentalCountBuilder from(IMode mode) {
        this.mode = mode;
        return this;
    }

    @Override
    public IKey build() throws IMException {
        return coreObjectFactory.createKey(getId(), accidentalCount, accidentalSymbol, mode);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importKeyFromAccidentalCount(this, inputOutputType);
    }
}
