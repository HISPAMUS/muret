package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Used as a convenience class serving as base for all classes wrapping an enum
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public abstract class EnumCoreProperty<EnumType> extends CoreProperty {
    @NotNull
    protected final EnumType enumValue;

    public EnumCoreProperty(@Nullable IId id, @NotNull EnumType enumValue) {
        super(id);
        this.enumValue = enumValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnumCoreProperty)) return false;

        EnumCoreProperty<?> enumCoreProperty = (EnumCoreProperty<?>) o;

        return enumValue.equals(enumCoreProperty.enumValue);
    }

    @Override
    public int hashCode() {
        return enumValue.hashCode();
    }

    @Override
    public String toString() {
        return enumValue.toString();
    }
}
