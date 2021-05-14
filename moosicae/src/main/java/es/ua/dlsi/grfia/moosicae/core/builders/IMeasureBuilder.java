package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeasure;
import es.ua.dlsi.grfia.moosicae.core.properties.ILeftBarline;
import es.ua.dlsi.grfia.moosicae.core.properties.INumber;
import es.ua.dlsi.grfia.moosicae.core.properties.IRightBarline;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/05/2020
 */
public class IMeasureBuilder extends CoreObjectBuilder<IMeasure>  {
    private ILeftBarline leftBarline;
    private IRightBarline rightBarline;
    private INumber barNumber;

    public IMeasureBuilder() {}

    public IMeasureBuilder from(ILeftBarline leftBarline) {
        this.leftBarline = leftBarline;
        return this;
    }

    public IMeasureBuilder from(IRightBarline rightBarline) {
        this.rightBarline = rightBarline;
        return this;
    }

    public IMeasureBuilder from(INumber barNumber) {
        this.barNumber = barNumber;
        return this;
    }

    @Override
    public IMeasure build() throws IMException {
        return ICoreAbstractFactory.getInstance().createMeasure(getId(), barNumber, leftBarline, rightBarline);
    }

}
