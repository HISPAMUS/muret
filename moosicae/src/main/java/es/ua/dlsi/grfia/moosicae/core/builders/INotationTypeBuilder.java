package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.INotationType;
import es.ua.dlsi.grfia.moosicae.core.enums.ENotationTypes;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class INotationTypeBuilder extends CoreObjectBuilder<INotationType> {
    private ENotationTypes notationType;
    public INotationTypeBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setNotationType(ENotationTypes notationType) {
        this.notationType = notationType;
    }

    @Override
    public INotationType build() throws IMException {
        assertRequired("notationType", notationType);
        return coreObjectFactory.createNotationType(getId(), notationType);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importNotationType(this, inputOutputType);
    }
}
