package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MEIStaff extends MEIObject {
    @NotNull
    private final MEILayer [] layers;
    @NotNull
    private final Integer n;

    public MEIStaff(IId id, @NotNull MEILayer[] layers, Integer n) {
        super(id);
        this.layers = layers;
        this.n = n;
    }

    public MEILayer[] getLayers() {
        return layers;
    }

    @Override
    public MEIStaff clone() {
        return new MEIStaff(id, layers, n);
    }

    public Integer getN() {
        return n;
    }

    @Override
    public String toString() {
        return "MEIStaff{" +
                "layers=" + Arrays.toString(layers) +
                ", n=" + n +
                "} " + super.toString();
    }
}
