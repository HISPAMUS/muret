package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.core.IConnector;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;

import java.util.LinkedList;
import java.util.List;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class IConnectorBuilder<T extends IConnector> extends CoreObjectBuilder<T> {
    protected List<IVoiced> connected;

    public IConnectorBuilder() {
        connected = new LinkedList<>();
    }

    public IConnectorBuilder add(IVoiced child) {
        this.connected.add(child);
        return this;
    }
}
