package es.ua.dlsi.grfia.moosicae.core;

/**
 * e.g. 3/2=6/4, both can be used. Both meters must take the same duration
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 06/04/2020
 */
public interface IInterchangingMeter extends IMeter {
    IMeter getLeft();
    IMeter getRight();
}
