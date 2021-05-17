package es.ua.dlsi.grfia.moosicae.core;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 17/5/21
 */
public interface IConnector extends IMooObject {
    IVoiced[] getConnected();
    IVoiced getFirst();
    IVoiced getLast();

    /**
     * The framework is responsible to maintaining the bidirectional association
     */
    void add(IVoiced voiced);
}
