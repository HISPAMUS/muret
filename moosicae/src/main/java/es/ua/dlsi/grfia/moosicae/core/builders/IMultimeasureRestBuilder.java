package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IMultimeasureRestBuilder extends CoreObjectBuilder<IMultimeasureRest> {
    private Integer count;

    public IMultimeasureRestBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public IMultimeasureRest build() throws IMException {
        assertRequired("count", count);
        return coreObjectFactory.createMultimeasureRest(getId(), count);
    }
}
