package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.ETimeSignatureSymbols;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IFractionalTimeSignatureBuilder extends CoreObjectBuilder<IFractionalTimeSignature> {
    private ITimeSignatureNumrerator numerator;
    private ITimeSignatureDenominator denominator;
    private ETimeSignatureSymbols timeSignatureSymbol;

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

    public IFractionalTimeSignatureBuilder from(ETimeSignatureSymbols timeSignatureSymbol) {
        this.timeSignatureSymbol = timeSignatureSymbol;
        return this;
    }

    @Override
    public IFractionalTimeSignature build() throws IMException {
        if (timeSignatureSymbol != null) {
            switch (timeSignatureSymbol) {
                case common:
                    return coreObjectFactory.createCommonTime(getId());
                case cut:
                    return coreObjectFactory.createCutTime(getId());
                default:
                    throw new IMException("Unknown time signature symbol: " + timeSignatureSymbol);
            }
        } else {
            return coreObjectFactory.createFractionalTimeSignature(getId(), numerator, denominator);
        }
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) throws IMException {
        importerVisitor.importFractionalTimeSignature(this, inputOutputType);
    }
}
