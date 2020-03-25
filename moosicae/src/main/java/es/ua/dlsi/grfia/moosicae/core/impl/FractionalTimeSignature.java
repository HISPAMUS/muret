package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ITimeSignatureDenominator;
import es.ua.dlsi.grfia.moosicae.core.ITimeSignatureNumerator;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IFractionalTimeSignature;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.utils.Time;
import org.apache.commons.lang3.math.Fraction;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class FractionalTimeSignature extends Meter implements IFractionalTimeSignature {
    @NotNull
    private final ITimeSignatureNumerator numerator;
    @NotNull
    private final ITimeSignatureDenominator denominator;
    @NotNull
    private final Time barDuration;

    FractionalTimeSignature(@NotNull IId id, @NotNull ITimeSignatureNumerator numerator, @NotNull ITimeSignatureDenominator denominator) {
        super(id);
        this.numerator = numerator;
        this.denominator = denominator;
        this.barDuration = new Time(Fraction.getFraction(numerator.getValue(), 1).multiplyBy(Fraction.getFraction(4, denominator.getValue())));
    }

    @Override
    public ITimeSignatureNumerator getNumerator() {
        return numerator;
    }

    @Override
    public ITimeSignatureDenominator getDenominator() {
        return denominator;
    }

    @Override
    public Time getBarDuration() {
        return barDuration;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportFractionalTimeSignature(this, inputOutput);
    }

    @Override
    public FractionalTimeSignature clone() {
        return new FractionalTimeSignature(IdGenerator.getInstance().generateUniqueId(), numerator, denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FractionalTimeSignature)) return false;

        FractionalTimeSignature that = (FractionalTimeSignature) o;

        if (!numerator.equals(that.numerator)) return false;
        if (!denominator.equals(that.denominator)) return false;
        return barDuration.equals(that.barDuration);
    }

    @Override
    public int hashCode() {
        int result = numerator.hashCode();
        result = 31 * result + denominator.hashCode();
        result = 31 * result + barDuration.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FractionalTimeSignature{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
