package es.ua.dlsi.grfia.moosicae.core.properties;

import es.ua.dlsi.grfia.moosicae.core.ICoreProperty;

import java.util.Optional;

/**
 * Ties are always linked to the note that starts it
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public interface ITie extends ICoreProperty {
    Optional<ITieOrientation> getOrientation();
}
