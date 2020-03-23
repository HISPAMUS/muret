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

    public IFractionalTimeSignatureBuilder from(ITimeSignatureNumrerator numerator) {
        this.numerator = numerator;
        return this;
    }

    public IFractionalTimeSignatureBuilder from(ITimeSignatureDenominator denominator) {
        this.denominator = denominator;
        return this;
    }

    @Override
    public IFractionalTimeSignature build() throws IMException {
        return coreObjectFactory.createFractionalTimeSignature(getId(), numerator, denominator);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importFractionalTimeSignature(this, inputOutputType);
    }
}
