package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.properties.INumber;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public interface IBarline extends INonDurational {
    Optional<INumber> getBarNumber();
    Optional<IBarlineType> getBarlineType();
}
