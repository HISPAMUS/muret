package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IConnector;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 17/5/21
 */
public abstract class Connector extends CoreObject implements IConnector {
    @NotNull
    protected List<IVoiced> connected;
    /**
     * @param id If id is null, a new id is generated. If not null, the value is assigned
     */
    public Connector(IId id) {
        super(id);
        this.connected = new LinkedList<>();
    }

    /**
     * @param id If id is null, a new id is generated. If not null, the value is assigned
     */
    public Connector(IId id, IVoiced [] connected) {
        super(id);
        this.connected = Arrays.asList(connected);
        for (IVoiced voiced: connected) {
            ((Voiced)voiced).addConnector(this);
        }
    }

    @Override
    public IVoiced[] getConnected() {
        return connected.toArray(new IVoiced[connected.size()]);
    }

    @Override
    public IVoiced getFirst() {
        if (connected.isEmpty()) {
            return null;
        }
        return connected.get(0);
    }

    @Override
    public IVoiced getLast() {
        if (connected.isEmpty()) {
            return null;
        }
        return connected.get(connected.size()-1);
    }

    @Override
    public void add(IVoiced item) {
        this.connected.add(item);
        ((Voiced)item).addConnector(this);
    }


}
