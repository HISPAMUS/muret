package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.impl.MooObject;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.ICoreProperty;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public abstract class CoreProperty extends MooObject implements ICoreProperty {
    public CoreProperty(IId id) {
        super(id);
    }
    public abstract CoreProperty clone();
}
