package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBeamGroup;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 30/10/2020
 */
public class IBeamGroupBuilder extends IConnectorBuilder<IBeamGroup> {
    public IBeamGroupBuilder(){
    }

    @Override
    public IBeamGroup build() throws IMException {
        if (connected.isEmpty()) {
            throw new IMException("The connected items list cannot be empty");
        }
        return ICoreAbstractFactory.getInstance().createBeamGroup(getId(), (IVoiced[])connected.toArray(new IVoiced[0]));
    }
}
