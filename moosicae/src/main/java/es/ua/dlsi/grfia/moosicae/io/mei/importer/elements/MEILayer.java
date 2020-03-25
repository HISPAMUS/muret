package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.ICoreItem;
import es.ua.dlsi.grfia.moosicae.core.ICoreObject;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MEILayer implements ICoreObject {
    @NotNull
    private final IId id;

    @NotNull
    private final ICoreItem [] items;

    public MEILayer(@NotNull IId id, @NotNull ICoreItem[] items) {
        this.id = id;
        this.items = items;
    }

    @Override
    public IId getId() {
        return id;
    }

    public ICoreItem[] getItems() {
        return items;
    }

    @Override
    public MEILayer clone() {
        return new MEILayer(id, items);
    }
}
