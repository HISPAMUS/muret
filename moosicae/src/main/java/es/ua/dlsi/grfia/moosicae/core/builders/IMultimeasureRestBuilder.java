package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IMultimeasureRestCountBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.IMultimeasureRestCount;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IMultimeasureRestBuilder extends CoreObjectBuilder<IMultimeasureRest> {
    private IMultimeasureRestCount count;

    public IMultimeasureRestBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IMultimeasureRestBuilder from(IMultimeasureRestCount count) {
        this.count = count;
        return this;
    }

    @Override
    public IMultimeasureRest build() throws IMException {
        return coreObjectFactory.createMultimeasureRest(getId(), count);
    }

}
