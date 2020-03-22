package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IMultimeasureRestBuilder extends CoreObjectBuilder<IMultimeasureRest> {
    private Integer count;

    public IMultimeasureRestBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public IMultimeasureRest build() throws IMException {
        assertRequired("count", count);
        return coreObjectFactory.createMultimeasureRest(getId(), count);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importMutimeasureRest(this, inputOutputType);
    }
}
