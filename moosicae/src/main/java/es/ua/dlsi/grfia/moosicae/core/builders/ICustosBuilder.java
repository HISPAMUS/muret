package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class ICustosBuilder extends CoreObjectBuilder<ICustos> {
    private  IPitch pitch;
    public ICustosBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setPitch(IPitch pitch) {
        this.pitch = pitch;
    }

    @Override
    public ICustos build() throws IMException {
        assertRequired("pitch", pitch);
        return coreObjectFactory.createCustos(getId(), pitch);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importCustos(this, inputOutputType);
    }
}
