package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.IVoicedItem;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MEILayer extends MEIObject {
    @NotNull
    private final IVoicedItem[] items;
    @NotNull
    private final Integer n;

    public MEILayer(IId id, @NotNull IVoicedItem[] items, Integer n) {
        super(id);
        this.items = items;
        this.n = n;
    }

    public IVoicedItem[] getItems() {
        return items;
    }

    @Override
    public MEILayer clone() {
        return new MEILayer(id, items, n);
    }

    public Integer getN() {
        return n;
    }

    @Override
    public String toString() {
        return "MEILayer{" +
                "items=" + Arrays.toString(items) +
                ", n=" + n +
                "} " + super.toString();
    }
}
