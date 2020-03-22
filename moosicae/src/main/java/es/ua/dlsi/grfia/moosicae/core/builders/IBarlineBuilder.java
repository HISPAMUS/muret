package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBarline;
import es.ua.dlsi.grfia.moosicae.core.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.INumber;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IBarlineBuilder extends CoreObjectBuilder<IBarline>  {
    private IBarlineType barlineType;
    private INumber barNumber;

    public IBarlineBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }


    public void setBarlineType(IBarlineType barlineType) {
        this.barlineType = barlineType;
    }

    public void setBarNumber(INumber barNumber) {
        this.barNumber = barNumber;
    }

    @Override
    public IBarline build() throws IMException {
        return coreObjectFactory.createBarline(getId(), barNumber, barlineType);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importBarline(this, inputOutputType);
    }
}
