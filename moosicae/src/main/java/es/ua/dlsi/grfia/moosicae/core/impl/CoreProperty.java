package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.ICoreProperty;
import org.jetbrains.annotations.Nullable;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public abstract class CoreProperty extends CoreObject implements ICoreProperty {
    public CoreProperty(@Nullable IId id) {
        super(id);
    }
    public abstract CoreProperty clone();
}
