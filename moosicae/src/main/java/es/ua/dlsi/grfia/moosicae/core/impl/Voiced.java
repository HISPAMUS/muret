package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IConnector;
import es.ua.dlsi.grfia.moosicae.core.IMark;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/5/21
 */
public abstract class Voiced extends MooObject implements IVoiced {
    /**
     * As each element will have very few connectors, most of them none, by default we leave it null, and we use brute force for searching the list
     * as it will be faster than using any other kind of data type
     */
    private List<IConnector> connectors;

    private List<IMark> marks;

    /**
     * @param id If id is null, a new id is generated. If not null, the value is assigned
     */
    public Voiced(IId id) {
        super(id);
        connectors = null;
        marks = null;
    }

    /**
     * This is usually used by the connector itself
     * @param connector
     */
    public void addConnector(IConnector connector) {
        boolean found = false;
        if (connectors != null) {
            for (IConnector c : connectors) {
                if (c == connector) {
                    found = true;
                    break;
                }
            }
        } else {
            connectors = new LinkedList<>();
        }
        if (!found) {
            connectors.add(connector);
        }
    }

    @Override
    public IConnector[] getConnectors() {
        if (connectors == null) {
            return new IConnector[0];
        } else {
            return connectors.toArray(new IConnector[connectors.size()]);
        }
    }

    @Override
    public void addMark(IMark mark) {
        if (marks == null) {
            marks = new LinkedList<>();
        }
        this.marks.add(mark);
    }

    @Override
    public IMark[] getMarks() {
        if (marks == null) {
            return new IMark[0];
        } else {
            return marks.toArray(new IMark[0]);
        }
    }
}