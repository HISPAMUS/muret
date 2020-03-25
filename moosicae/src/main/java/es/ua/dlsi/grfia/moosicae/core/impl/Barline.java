package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBarline;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.properties.INumber;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;


import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class Barline extends CoreItem implements IBarline {

    private INumber barNumber;

    private IBarlineType barlineType;

    Barline(IId id,  INumber barNumber,  IBarlineType barlineType) {
        super(id);
        this.barNumber = barNumber;
        this.barlineType = barlineType;
    }

    @Override
    public Optional<INumber> getBarNumber() {
        return Optional.ofNullable(barNumber);
    }

    @Override
    public Optional<IBarlineType> getBarlineType() {
        return Optional.ofNullable(barlineType);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportBarline(this, inputOutput);
    }

    @Override
    public Barline clone() {
        return new Barline(null, barNumber, barlineType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Barline)) return false;

        Barline barline = (Barline) o;

        if (barNumber != null ? !barNumber.equals(barline.barNumber) : barline.barNumber != null) return false;
        return barlineType != null ? barlineType.equals(barline.barlineType) : barline.barlineType == null;
    }

    @Override
    public int hashCode() {
        int result = barNumber != null ? barNumber.hashCode() : 0;
        result = 31 * result + (barlineType != null ? barlineType.hashCode() : 0);
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
