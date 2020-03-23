package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.properties.IMetronomeMarkValue;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class IIMetronomeMarkValueBuilder extends IIntegerPropertyBuilder<IMetronomeMarkValue>  {
    public IIMetronomeMarkValueBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public IMetronomeMarkValue build() throws IMException {
        return coreObjectFactory.createMetronomeMarkValue(getId(), value);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importMetronomeMarkValue(this, inputOutputType);
    }
}
