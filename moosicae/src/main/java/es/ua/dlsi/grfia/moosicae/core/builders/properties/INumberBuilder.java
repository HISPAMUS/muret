package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.INumber;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class INumberBuilder extends CoreObjectBuilder<INumber> {
    protected Integer value;

    public INumberBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public INumberBuilder from(Integer value) {
        this.value = value;
        return this;
    }

    @Override
    public INumber build() throws IMException {
        return coreObjectFactory.createNumber(getId(), value);
    }


}
