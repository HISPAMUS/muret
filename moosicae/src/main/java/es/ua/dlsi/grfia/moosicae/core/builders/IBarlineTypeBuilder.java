package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.enums.EBarlineTypes;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IBarlineTypeBuilder extends CoreObjectBuilder<IBarlineType>  {
    private EBarlineTypes barlineType;

    public IBarlineTypeBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setBarlineType(EBarlineTypes barlineType) {
        this.barlineType = barlineType;
    }

    @Override
    public IBarlineType build() throws IMException {
        assertRequired("barlineTypes", barlineType);
        return coreObjectFactory.createBarlineType(getId(), barlineType);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importBarlineType(this, inputOutputType);
    }
}
