package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.properties.IMultimeasureRestCount;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class IMultimeasureRestCountBuilder extends IIntegerPropertyBuilder<IMultimeasureRestCount>  {

    @Override
    public IMultimeasureRestCount build() throws IMException {
        return ICoreAbstractFactory.getInstance().createMultimeasureRestCount(getId(), value);
    }


}
