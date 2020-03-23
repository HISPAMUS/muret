package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IPitch;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IChord extends IPitched, IDurationalSingle {
    IPitch[] getPitches();
}
