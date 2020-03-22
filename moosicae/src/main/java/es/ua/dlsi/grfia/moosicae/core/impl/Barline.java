package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBarline;
import es.ua.dlsi.grfia.moosicae.core.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class Barline extends CoreItem implements IBarline {
    @Nullable
    private Integer barNumber;
    @NotNull
    private IBarlineType barlineType;

    Barline(@NotNull IId id, @Nullable Integer barNumber, @NotNull IBarlineType barlineType) {
        super(id);
        this.barNumber = barNumber;
        this.barlineType = barlineType;
    }

    @Override
    public Optional<Integer> getBarNumber() {
        return Optional.ofNullable(barNumber);
    }

    @Override
    public Optional<IBarlineType> getBarlineType() {
        return Optional.ofNullable(barlineType);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public Barline clone() {
        return new Barline(IdGenerator.getInstance().generateUniqueId(), barNumber, barlineType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Barline)) return false;

        Barline barline = (Barline) o;

        if (barNumber != null ? !barNumber.equals(barline.barNumber) : barline.barNumber != null) return false;
        return barlineType.equals(barline.barlineType);
    }

    @Override
    public int hashCode() {
        int result = barNumber != null ? barNumber.hashCode() : 0;
        result = 31 * result + barlineType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Barline{" +
                "barNumber=" + barNumber +
                ", barlineType=" + barlineType +
                "} " + super.toString();
    }
}
