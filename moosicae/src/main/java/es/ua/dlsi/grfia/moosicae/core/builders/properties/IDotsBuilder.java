package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.IDots;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class IDotsBuilder extends CoreObjectBuilder<IDots> {
    protected Integer value;

    public IDotsBuilder() {}

    public IDotsBuilder from(Integer value) {
        this.value = value;
        return this;
    }

    @Override
    public IDots build() throws IMException {
        return ICoreAbstractFactory.getInstance().createDots(getId(), value);
    }
}
