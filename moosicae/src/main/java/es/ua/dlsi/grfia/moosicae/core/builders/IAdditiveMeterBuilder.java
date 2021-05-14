package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.ITimeSignatureDenominator;
import es.ua.dlsi.grfia.moosicae.core.properties.ITimeSignatureNumerator;

import java.util.LinkedList;
import java.util.List;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IAdditiveMeterBuilder extends CoreObjectBuilder<IAdditiveMeter> {
    private List<ITimeSignatureNumerator> numerators;
    private ITimeSignatureDenominator denominator;

    public IAdditiveMeterBuilder() {
        numerators = new LinkedList<>();
    }

    public IAdditiveMeterBuilder add(ITimeSignatureNumerator numerator) {
        this.numerators.add(numerator);
        return this;
    }

    public IAdditiveMeterBuilder from(ITimeSignatureDenominator denominator) {
        this.denominator = denominator;
        return this;
    }


    @Override
    public IAdditiveMeter build() throws IMException {
        return ICoreAbstractFactory.getInstance().createAdditiveMeter(getId(), numerators.toArray(new ITimeSignatureNumerator[0]), denominator);
    }

}
