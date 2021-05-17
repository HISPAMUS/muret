package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.properties.IName;
import es.ua.dlsi.grfia.moosicae.core.properties.INoteHead;

import java.util.Optional;

/**
 * A composite pattern is used because the voice may contain a list of symbols where a symbol may be a note or other voice
 * (e.g. a divisi)
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IVoice extends IVoicedComposite {
    Optional<IName> getName();
    //TODO Add another interface in charge of tied notes
    void tie(INoteHead prev, INoteHead next) throws IMException;
    void untie(INoteHead prev, INoteHead next) throws IMException;

}
