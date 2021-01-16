package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IRest;
import es.ua.dlsi.grfia.moosicae.core.IWholeMeasureRest;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IWholeMeasureRestBuilder extends IMultimeasureRestBuilder {

    public IWholeMeasureRestBuilder(){
    }

    @Override
    public IWholeMeasureRest build() throws IMException {
        if (this.children.size() != 1) {
            throw new IMException("Expected 1 child, and found " + this.children.size());
        }
        return ICoreAbstractFactory.getInstance().createWholeMeasureRest(getId(), (IRest)this.children.get(0));
    }

}
