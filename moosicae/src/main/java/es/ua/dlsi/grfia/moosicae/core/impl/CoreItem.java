package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.ICoreItem;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class CoreItem extends CoreObject implements ICoreItem {
    public CoreItem(@NotNull IId id) {
        super(id);
    }

    public abstract CoreItem clone();
}
