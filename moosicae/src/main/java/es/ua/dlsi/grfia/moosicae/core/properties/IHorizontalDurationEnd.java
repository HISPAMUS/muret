package es.ua.dlsi.grfia.moosicae.core.properties;

import es.ua.dlsi.grfia.moosicae.core.adt.ITime;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/1/21
 */
public interface IHorizontalDurationEnd extends IHorizontalEnd {
    ITime getDuration();
}
