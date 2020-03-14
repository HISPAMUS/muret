package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.utils.Time;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IDurational extends ISymbol, IStaffElement {
    Time getDuration();
}
