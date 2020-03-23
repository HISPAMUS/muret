package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IMultimeasureRestCount;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IMultimeasureRest extends IDurationalComposite {
    IMultimeasureRestCount getMeasureCount();
}
