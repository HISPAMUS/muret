package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IFractionalTimeSignatureBuilder extends CoreObjectBuilder<IFractionalTimeSignature> {
    private ITimeSignatureNumrerator numerator;
    private ITimeSignatureDenominator denominator;

    public IFractionalTimeSignatureBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setNumerator(ITimeSignatureNumrerator numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(ITimeSignatureDenominator denominator) {
        this.denominator = denominator;
    }

    @Override
    public IFractionalTimeSignature build() throws IMException {
        assertRequired("numerator", numerator);
        assertRequired("denominator", denominator);
        return coreObjectFactory.createFractionalTimeSignature(getId(), numerator, denominator);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importFractionalTimeSignature(this, inputOutputType);
    }
}
