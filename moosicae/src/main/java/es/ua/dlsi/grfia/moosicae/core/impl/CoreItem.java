package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.ICoreItem;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class CoreItem extends CoreObject implements ICoreItem {
    public CoreItem(IId id) {
        super(id);
    }

    public abstract CoreItem clone();
}
