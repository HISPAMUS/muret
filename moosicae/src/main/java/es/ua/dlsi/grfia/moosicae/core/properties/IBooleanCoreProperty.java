package es.ua.dlsi.grfia.moosicae.core.properties;

import es.ua.dlsi.grfia.moosicae.core.ICoreProperty;

/**
 * A property that will always be a boolean
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public interface IBooleanCoreProperty extends ICoreProperty {
    Boolean getValue();
}
