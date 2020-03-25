package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ITimeSignatureNumerator;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class ITimeSignatureNumeratorBuilder extends IIntegerPropertyBuilder<ITimeSignatureNumerator>  {
    public ITimeSignatureNumeratorBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public ITimeSignatureNumerator build() throws IMException {
        return coreObjectFactory.createTimeSignatureNumerator(getId(), value);
    }


}
