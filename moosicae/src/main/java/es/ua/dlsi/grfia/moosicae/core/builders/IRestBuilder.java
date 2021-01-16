package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IRestBuilder extends IDurationalSingleBuilder<IRest> {

    public IRestBuilder(){
    }

    @Override
    public IRest build() throws IMException {
        return ICoreAbstractFactory.getInstance().createRest(getId(), figure, dots);
    }

}
