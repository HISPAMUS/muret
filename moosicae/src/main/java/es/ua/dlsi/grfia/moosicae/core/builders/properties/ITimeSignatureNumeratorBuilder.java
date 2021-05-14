package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.properties.ITimeSignatureNumerator;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class ITimeSignatureNumeratorBuilder extends IIntegerPropertyBuilder<ITimeSignatureNumerator>  {
    public ITimeSignatureNumeratorBuilder(){
    }

    @Override
    public ITimeSignatureNumerator build() throws IMException {
        return ICoreAbstractFactory.getInstance().createTimeSignatureNumerator(getId(), value);
    }


}
