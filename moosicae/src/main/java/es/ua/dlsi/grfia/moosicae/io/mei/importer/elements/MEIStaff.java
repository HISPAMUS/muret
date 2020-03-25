package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.ICoreObject;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MEIStaff implements ICoreObject {
    @NotNull
    private final IId id;
    @NotNull
    private final MEILayer [] layers;

    public MEIStaff(@NotNull IId id, @NotNull MEILayer[] layers) {
        this.id = id;
        this.layers = layers;
    }

    public MEILayer[] getLayers() {
        return layers;
    }

    @Override
    public IId getId() {
        return id;
    }

    @Override
    public MEIStaff clone() {
        return new MEIStaff(id, layers);
    }
}
