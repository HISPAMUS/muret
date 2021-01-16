package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.properties.IMetronomeMarkValue;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class IIMetronomeMarkValueBuilder extends IIntegerPropertyBuilder<IMetronomeMarkValue>  {

    @Override
    public IMetronomeMarkValue build() throws IMException {
        return ICoreAbstractFactory.getInstance().createMetronomeMarkValue(getId(), value);
    }

}
