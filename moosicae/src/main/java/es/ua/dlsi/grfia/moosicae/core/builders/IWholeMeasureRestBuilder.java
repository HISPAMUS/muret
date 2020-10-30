package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IWholeMeasureRest;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IWholeMeasureRestBuilder extends CoreObjectBuilder<IWholeMeasureRest> {

    public IWholeMeasureRestBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public IWholeMeasureRest build() throws IMException {
        return coreObjectFactory.createWholeMeasureRest(getId());
    }

}
