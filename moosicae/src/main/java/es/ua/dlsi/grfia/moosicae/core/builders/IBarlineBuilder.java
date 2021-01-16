package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBarline;
import es.ua.dlsi.grfia.moosicae.core.properties.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.properties.INumber;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IBarlineBuilder extends CoreObjectBuilder<IBarline>  {
    private IBarlineType barlineType;
    private INumber barNumber;

    public IBarlineBuilder() {}


    public IBarlineBuilder from(IBarlineType barlineType) {
        this.barlineType = barlineType;
        return this;
    }

    public IBarlineBuilder from(INumber barNumber) {
        this.barNumber = barNumber;
        return this;
    }

    @Override
    public IBarline build() throws IMException {
        return ICoreAbstractFactory.getInstance().createBarline(getId(), barNumber, barlineType);
    }

}
