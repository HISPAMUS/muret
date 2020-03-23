package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.enums.mensural.EMensurations;
import es.ua.dlsi.grfia.moosicae.core.mensural.IMensuration;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IMensurationBuilder extends CoreObjectBuilder<IMensuration> {
    private EMensurations mensurations;

    public IMensurationBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IMensurationBuilder from(EMensurations mensurations) {
        this.mensurations = mensurations;
        return this;
    }

    @Override
    public IMensuration build() throws IMException {
        return coreObjectFactory.createMensuration(getId(), mensurations);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importMensuration(this, inputOutputType);
    }
}
