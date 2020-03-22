package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IClefSign;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IClefSignBuilder extends CoreObjectBuilder<IClefSign>  {
    private EClefSigns clefSign;

    public IClefSignBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setClefSign(EClefSigns clefSign) {
        this.clefSign = clefSign;
    }

    @Override
    public IClefSign build() throws IMException {
        assertRequired("clefSign", clefSign);
        return coreObjectFactory.createClefSign(getId(), clefSign);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importClefSign(this, inputOutputType);
    }
}
