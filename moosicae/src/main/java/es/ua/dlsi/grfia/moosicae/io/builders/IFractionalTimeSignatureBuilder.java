package es.ua.dlsi.grfia.moosicae.io.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IFractionalTimeSignatureBuilder extends CoreObjectBuilder<IFractionalTimeSignature> {
    private Integer numerator;
    private Integer denominator;

    public IFractionalTimeSignatureBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setNumerator(Integer numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(Integer denominator) {
        this.denominator = denominator;
    }

    @Override
    public IFractionalTimeSignature build() throws IMException {
        assertRequired("numerator", numerator);
        assertRequired("denominator", denominator);
        return coreObjectFactory.createFractionalTimeSignature(numerator, denominator);
    }
}
