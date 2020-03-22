package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.IName;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class Name extends CoreProperty implements IName {
    @NotNull
    private final String value;

    public Name(@NotNull IId id, @NotNull String value) {
        super(id);
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public CoreProperty clone() {
        return new Name(id, value);
    }

    @Override
    public String toString() {
        return "Name{" +
                "value='" + value + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;

        Name name = (Name) o;

        return value.equals(name.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
