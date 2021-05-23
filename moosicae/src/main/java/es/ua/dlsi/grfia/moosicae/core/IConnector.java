package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.IMException;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 17/5/21
 */
public interface IConnector extends IMooObject {
    IVoiced[] getConnected();
    IVoiced getFirst() throws IMException;
    IVoiced getLast() throws IMException;

    /**
     * The framework is responsible to maintaining the bidirectional association
     */
    void add(IVoiced voiced);
}
