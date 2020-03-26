package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.enums.EModes;
import es.ua.dlsi.grfia.moosicae.core.properties.IMode;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IModeBuilder extends CoreObjectBuilder<IMode> {
    private EModes value;

    public IModeBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IModeBuilder from(EModes value) {
        this.value = value;
        return this;
    }

    @Override
    public IMode build() throws IMException {
        return coreObjectFactory.createMode(getId(), value);
    }

}
