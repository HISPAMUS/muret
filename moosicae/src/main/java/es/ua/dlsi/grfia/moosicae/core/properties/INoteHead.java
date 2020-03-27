package es.ua.dlsi.grfia.moosicae.core.properties;

import es.ua.dlsi.grfia.moosicae.core.ICoreProperty;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 26/03/2020
 */
public interface INoteHead extends ICoreProperty {
    IPitch getPitch();

    /**
     * The tie begins in this note
     * @return
     */
    Optional<ITie> getStartsTie();
}
