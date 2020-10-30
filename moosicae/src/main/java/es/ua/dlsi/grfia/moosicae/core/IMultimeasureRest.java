package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IMultimeasureRestCount;

/**
 * It is composite because it can be represented a traditional style of rests is used (using a combination of longa --taking 4 measures, brevis --taking 2, whole rests taking 1) with a numeral above showing the number of measures the rest takes, or just a multi-measure rest with that numeral above.
 * When using a single rest, the composite will contain just one element
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IMultimeasureRest extends IDurationalComposite {
    IMultimeasureRestCount getMeasureCount();
}
