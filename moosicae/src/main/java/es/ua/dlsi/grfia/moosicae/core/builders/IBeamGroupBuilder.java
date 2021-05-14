package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBeamGroup;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IDurational;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 30/10/2020
 */
public class IBeamGroupBuilder extends IDurationalCompositeBuilder<IBeamGroup> {
    public IBeamGroupBuilder(){
    }

    @Override
    public IBeamGroup build() throws IMException {
        if (children.isEmpty()) {
            throw new IMException("The children cannot be empty");
        }
        return ICoreAbstractFactory.getInstance().createBeamGroup(getId(), (IDurational[])children.toArray(new IDurational[0]));
    }
}
