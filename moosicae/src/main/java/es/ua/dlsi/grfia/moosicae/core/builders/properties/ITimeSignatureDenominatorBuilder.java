package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ITimeSignatureDenominator;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class ITimeSignatureDenominatorBuilder extends IIntegerPropertyBuilder<ITimeSignatureDenominator>  {
    public ITimeSignatureDenominatorBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public ITimeSignatureDenominator build() throws IMException {
        return coreObjectFactory.createTimeSignatureDenominator(getId(), value);
    }


}
