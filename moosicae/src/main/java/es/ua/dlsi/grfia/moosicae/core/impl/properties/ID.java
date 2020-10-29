package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class ID implements IId {
    @NotNull
    private final String id;

    private boolean generated;

    public ID(@NotNull String id, boolean generated) {
        this.id = id;
        this.generated = generated;
    }

    @Override
    public String getValue() {
        return id;
    }

    @Override
    public boolean isGenerated() {
        return generated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ID)) return false;

        ID id1 = (ID) o;

        return id.equals(id1.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "ID{" +
                "id='" + id + '\'' +
                '}';
    }
}
