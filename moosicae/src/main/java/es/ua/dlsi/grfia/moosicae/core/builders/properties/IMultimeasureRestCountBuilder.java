package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.properties.IMultimeasureRestCount;
import es.ua.dlsi.grfia.moosicae.core.properties.IOctave;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class IMultimeasureRestCountBuilder extends IIntegerPropertyBuilder<IMultimeasureRestCount>  {
    public IMultimeasureRestCountBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public IMultimeasureRestCount build() throws IMException {
        return coreObjectFactory.createMultimeasureRestCount(getId(), value);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importMultimeasureRestCount(this, inputOutputType);
    }
}
