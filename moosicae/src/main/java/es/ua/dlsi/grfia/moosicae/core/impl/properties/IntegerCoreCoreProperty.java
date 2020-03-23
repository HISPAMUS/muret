package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IIntegerCoreProperty;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public abstract class IntegerCoreCoreProperty extends CoreProperty implements IIntegerCoreProperty {
    @NotNull
    protected final Integer value;

    public IntegerCoreCoreProperty(@NotNull IId id, @NotNull Integer value) {
        super(id);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerCoreCoreProperty)) return false;

        IntegerCoreCoreProperty that = (IntegerCoreCoreProperty) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public Integer getValue() {
        return value;
    }
}
