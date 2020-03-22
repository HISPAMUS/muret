package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Used as a convenience class serving as base for all classes wrapping an enum
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public abstract class EnumBased<EnumType> extends CoreProperty {
    @NotNull
    protected final EnumType enumValue;

    public EnumBased(@Nullable IId id, @NotNull EnumType enumValue) {
        super(id);
        this.enumValue = enumValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnumBased)) return false;

        EnumBased<?> enumBased = (EnumBased<?>) o;

        return enumValue.equals(enumBased.enumValue);
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
