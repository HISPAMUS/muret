package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IMode;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.enums.EModes;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IModeBuilder extends CoreObjectBuilder<IMode>  {
    private EModes mode;

    public IModeBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setMode(EModes mode) {
        this.mode = mode;
    }

    @Override
    public IMode build() throws IMException {
        assertRequired("mode", mode);
        return coreObjectFactory.createMode(mode);
    }
}
