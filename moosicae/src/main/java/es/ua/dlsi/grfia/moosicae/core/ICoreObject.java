package es.ua.dlsi.grfia.moosicae.core;

/**
 * By adding clone, hashCode, equals we force a canonical form of the class
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public interface ICoreObject extends Cloneable {
    IId getId();
    ICoreObject clone();
    int hashCode();
    boolean equals(Object o);
}
