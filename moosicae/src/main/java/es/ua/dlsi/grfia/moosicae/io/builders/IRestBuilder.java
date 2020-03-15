package es.ua.dlsi.grfia.moosicae.io.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IRestBuilder extends IDurationalSingleBuilder<IRest> {

    public IRestBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public IRest build() throws IMException {
        super.assertRequired();
        return coreObjectFactory.createRest(figure, Optional.ofNullable(dots));
    }
}
