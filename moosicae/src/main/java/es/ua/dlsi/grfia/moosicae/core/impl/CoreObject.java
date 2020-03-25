package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.ICoreObject;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public abstract class CoreObject implements ICoreObject {
    @NotNull
    protected final IId id;

    public CoreObject(IId id) {
        this.id = id;
    }

    @Override
    public IId getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{id=" + id + '}';
    }

    @Override
    public abstract CoreObject clone();
}
