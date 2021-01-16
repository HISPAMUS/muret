package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.core.IMultimeasureRest;
import es.ua.dlsi.grfia.moosicae.core.properties.IMultimeasureRestCount;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IMultimeasureRestBuilder extends IDurationalCompositeBuilder<IMultimeasureRest> {
    private IMultimeasureRestCount count;

    public IMultimeasureRestBuilder(){
    }

    public IMultimeasureRestBuilder from(IMultimeasureRestCount count) {
        this.count = count;
        return this;
    }

    @Override
    public IMultimeasureRest build() throws IMException {
        return ICoreAbstractFactory.getInstance().createMultimeasureRest(getId(), children.toArray(new IDurational[0]), count);
    }

}
