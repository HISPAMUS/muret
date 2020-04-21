package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IBooleanCoreProperty;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public abstract class BooleanCoreProperty extends CoreProperty implements IBooleanCoreProperty {
    @NotNull
    protected final Boolean value;

    public BooleanCoreProperty(IId id, @NotNull Boolean value) {
        super(id);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BooleanCoreProperty)) return false;

        BooleanCoreProperty that = (BooleanCoreProperty) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public Boolean getValue() {
        return value;
    }
}
