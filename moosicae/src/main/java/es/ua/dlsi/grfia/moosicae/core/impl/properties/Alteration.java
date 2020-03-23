package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.properties.IAlteration;
import es.ua.dlsi.grfia.moosicae.core.properties.IAlterationDisplayType;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Alteration extends CoreProperty implements IAlteration {
    @NotNull
    private final IAccidentalSymbol accidentalSymbol;
    @Nullable
    private final IAlterationDisplayType alterationDisplayType;

    public Alteration(@NotNull IId id, @NotNull IAccidentalSymbol accidentalSymbol, @Nullable IAlterationDisplayType alterationDisplayType) {
        super(id);
        this.accidentalSymbol = accidentalSymbol;
        this.alterationDisplayType = alterationDisplayType;
    }

    @Override
    public IAccidentalSymbol getAccidentalSymbol() {
        return accidentalSymbol;
    }

    @Override
    public Optional<IAlterationDisplayType> getAlterationDisplayType() {
        return Optional.ofNullable(alterationDisplayType);
    }

    @Override
    public Alteration clone() {
        return new Alteration(IdGenerator.getInstance().generateUniqueId(), accidentalSymbol, alterationDisplayType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alteration)) return false;

        Alteration that = (Alteration) o;

        if (!accidentalSymbol.equals(that.accidentalSymbol)) return false;
        return alterationDisplayType != null ? alterationDisplayType.equals(that.alterationDisplayType) : that.alterationDisplayType == null;
    }

    @Override
    public int hashCode() {
        int result = accidentalSymbol.hashCode();
        result = 31 * result + (alterationDisplayType != null ? alterationDisplayType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Alteration{" +
                "accidentalSymbol=" + accidentalSymbol +
                ", alterationDisplayType=" + alterationDisplayType +
                "} " + super.toString();
    }
}
