package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.builders.properties.ITupletActual;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.ITupletNormal;

/**
 * It inherits from IVoicedComposite tp allow special cases such as clef changes in the middle of a tuplet.
 * These non durational items are not taken into account for the count of items
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/5/21
 */
public interface ITuplet extends IVoicedComposite {
    ITupletActual getActual();
    ITupletNormal getNormal();
}
