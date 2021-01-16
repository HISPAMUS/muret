package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.adt.ITime;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IMeter extends INonDurational {
    ITime getBarDuration();
}
