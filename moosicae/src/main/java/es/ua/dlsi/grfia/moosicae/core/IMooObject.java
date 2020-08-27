package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import java.util.Optional;

/**
 * By adding clone, hashCode, equals we force a canonical form of the class
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public interface IMooObject extends Cloneable {
    Optional<IId> getId();
    IMooObject clone();
    int hashCode();
    boolean equals(Object o);
}
