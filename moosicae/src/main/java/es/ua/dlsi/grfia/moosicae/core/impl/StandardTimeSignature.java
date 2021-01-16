package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ITimeSignatureDenominator;
import es.ua.dlsi.grfia.moosicae.core.ITimeSignatureNumerator;
import es.ua.dlsi.grfia.moosicae.core.adt.IFractionBuilder;
import es.ua.dlsi.grfia.moosicae.core.adt.ITime;
import es.ua.dlsi.grfia.moosicae.core.adt.ITimeBuilder;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IStandardTimeSignature;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class StandardTimeSignature extends Meter implements IStandardTimeSignature {
    @NotNull
    private final ITimeSignatureNumerator numerator;
    @NotNull
    private final ITimeSignatureDenominator denominator;
    @NotNull
    private final ITime barDuration;


    StandardTimeSignature(IId id, @NotNull ITimeSignatureNumerator numerator, @NotNull ITimeSignatureDenominator denominator) {
        super(id);
        this.numerator = numerator;
        this.denominator = denominator;
        this.barDuration = ITimeBuilder.getInstance().build(IFractionBuilder.getInstance().build(numerator.getValue()).multiplyBy(IFractionBuilder.getInstance().build(4, denominator.getValue())));
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
    public ITime getBarDuration() {
        return barDuration;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportStandardTimeSignature(this, inputOutput);
    }

    @Override
    public StandardTimeSignature clone() {
        return new StandardTimeSignature(null, numerator, denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardTimeSignature)) return false;

        StandardTimeSignature that = (StandardTimeSignature) o;

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
