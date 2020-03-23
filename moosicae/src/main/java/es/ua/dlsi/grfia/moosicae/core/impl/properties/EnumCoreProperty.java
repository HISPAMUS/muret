package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Used as a convenience class serving as base for all classes wrapping an enum
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public abstract class EnumCoreProperty<EnumType> extends CoreProperty {
    @NotNull
    protected final EnumType value;

    public EnumCoreProperty(@Nullable IId id, @NotNull EnumType value) {
        super(id);
        this.value = value;
    }

    public EnumType getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnumCoreProperty)) return false;

        EnumCoreProperty<?> enumCoreProperty = (EnumCoreProperty<?>) o;

        return value.equals(enumCoreProperty.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
