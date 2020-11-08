package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.ETimeSignatureSymbols;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IStandardTimeSignatureBuilder extends CoreObjectBuilder<IStandardTimeSignature> {
    private ITimeSignatureNumerator numerator;
    private ITimeSignatureDenominator denominator;
    private ETimeSignatureSymbols timeSignatureSymbol;

    public IStandardTimeSignatureBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IStandardTimeSignatureBuilder from(ITimeSignatureNumerator numerator) {
        this.numerator = numerator;
        return this;
    }

    public IStandardTimeSignatureBuilder from(ITimeSignatureDenominator denominator) {
        this.denominator = denominator;
        return this;
    }

    public IStandardTimeSignatureBuilder from(ETimeSignatureSymbols timeSignatureSymbol) {
        this.timeSignatureSymbol = timeSignatureSymbol;
        return this;
    }

    @Override
    public IStandardTimeSignature build() throws IMException {
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
            return coreObjectFactory.createStandardTimeSignature(getId(), numerator, denominator);
        }
    }

}