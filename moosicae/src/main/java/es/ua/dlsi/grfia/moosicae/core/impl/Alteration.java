package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.EAccidentals;
import es.ua.dlsi.grfia.moosicae.core.EAlterationDisplayType;
import es.ua.dlsi.grfia.moosicae.core.IAlteration;

import java.util.Objects;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Alteration implements IAlteration {
    private final EAccidentals accidental;
    private final Optional<EAlterationDisplayType> alterationDisplayType;

    Alteration(EAccidentals accidental, Optional<EAlterationDisplayType> alterationDisplayType) {
        this.accidental = accidental;
        this.alterationDisplayType = alterationDisplayType;
    }

    @Override
    public EAccidentals getAccidental() {
        return null;
    }

    @Override
    public Optional<EAlterationDisplayType> getAlterationDisplayType() {
        return Optional.empty();
    }

    @Override
    public Alteration clone() {
        return new Alteration(accidental, alterationDisplayType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alteration that = (Alteration) o;
        return accidental == that.accidental &&
                alterationDisplayType.equals(that.alterationDisplayType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accidental, alterationDisplayType);
    }

    @Override
    public String toString() {
        return "Alteration{" +
                "accidental=" + accidental +
                ", alterationDisplayType=" + alterationDisplayType +
                '}';
    }
}
