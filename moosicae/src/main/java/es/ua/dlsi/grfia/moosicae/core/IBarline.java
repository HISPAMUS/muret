package es.ua.dlsi.grfia.moosicae.core;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public interface IBarline extends INonDurational {
    Optional<Integer> getBarNumber();
    Optional<IBarlineType> getBarlineType();
}
