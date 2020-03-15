package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.IAlteration;
import es.ua.dlsi.grfia.moosicae.core.IAlterationDisplayType;

import java.util.Objects;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Alteration implements IAlteration {
    private final IAccidentalSymbol accidentalSymbol;
    private final Optional<IAlterationDisplayType> alterationDisplayType;

    Alteration(IAccidentalSymbol accidentalSymbol, Optional<IAlterationDisplayType> alterationDisplayType) {
        this.accidentalSymbol = accidentalSymbol;
        this.alterationDisplayType = alterationDisplayType;
    }

    @Override
    public IAccidentalSymbol getAccidentalSymbol() {
        return accidentalSymbol;
    }

    @Override
    public Optional<IAlterationDisplayType> getAlterationDisplayType() {
        return Optional.empty();
    }

    @Override
    public Alteration clone() {
        return new Alteration(accidentalSymbol, alterationDisplayType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alteration that = (Alteration) o;
        return accidentalSymbol == that.accidentalSymbol &&
                alterationDisplayType.equals(that.alterationDisplayType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accidentalSymbol, alterationDisplayType);
    }

    @Override
    public String toString() {
        return "Alteration{" +
                "accidental=" + accidentalSymbol +
                ", alterationDisplayType=" + alterationDisplayType +
                '}';
    }
}
