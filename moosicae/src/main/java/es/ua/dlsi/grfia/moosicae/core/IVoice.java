package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IName;

import java.util.Optional;

/**
 * A composite pattern is used because the voice may contain a list of symbols where a symbol may be a note or other voice
 * (e.g. a divisi)
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IVoice extends IVoiced {
    Optional<IName> getName();
    IVoiced[] getItems();
    void addItem(IVoiced voiced);
}
