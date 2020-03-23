package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.properties.IKeyAccidentalCount;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class IKeyAccidentalCountBuilder extends IIntegerPropertyBuilder<IKeyAccidentalCount> {
    public IKeyAccidentalCountBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public IKeyAccidentalCount build() throws IMException {
        return coreObjectFactory.createKeyAccidentalCount(getId(), value);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importKeyAccidentalCount(this, inputOutputType);
    }
}
