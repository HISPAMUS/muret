package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.impl.CoreObject;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.ICoreProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public abstract class CoreProperty extends CoreObject implements ICoreProperty {
    public CoreProperty(@NotNull IId id) {
        super(id);
    }
    public abstract CoreProperty clone();
}
