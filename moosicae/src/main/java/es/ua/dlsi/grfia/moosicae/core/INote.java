package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.INoteHead;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface INote extends IStemmed, IPitched {
    INoteHead getNoteHead();
}
