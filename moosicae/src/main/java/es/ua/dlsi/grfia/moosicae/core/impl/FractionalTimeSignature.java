package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IFractionalTimeSignature;
import es.ua.dlsi.grfia.moosicae.utils.Time;
import org.apache.commons.lang3.math.Fraction;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class FractionalTimeSignature extends Meter implements IFractionalTimeSignature {
    private final int numerator;
    private final int denominator;
    private final Time barDuration;

    public FractionalTimeSignature(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.barDuration = new Time(Fraction.getFraction(numerator, 1).multiplyBy(Fraction.getFraction(4, denominator)));
    }

    @Override
    public int getNumerator() {
        return numerator;
    }

    @Override
    public int getDenominator() {
        return numerator;
    }

    @Override
    public Time getBarDuration() {
        return barDuration;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public FractionalTimeSignature clone() {
        return new FractionalTimeSignature(numerator, denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FractionalTimeSignature)) return false;

        FractionalTimeSignature that = (FractionalTimeSignature) o;

        if (numerator != that.numerator) return false;
        return denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
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
