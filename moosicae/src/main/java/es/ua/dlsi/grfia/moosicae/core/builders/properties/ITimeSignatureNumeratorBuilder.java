package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ITimeSignatureNumrerator;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class ITimeSignatureNumeratorBuilder extends IIntegerPropertyBuilder<ITimeSignatureNumrerator>  {
    public ITimeSignatureNumeratorBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public ITimeSignatureNumrerator build() throws IMException {
        return coreObjectFactory.createTimeSignatureNumerator(getId(), value);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importTimeSignatureNumerator(this, inputOutputType);
    }
}
