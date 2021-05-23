package es.ua.dlsi.grfia.moosicae.core.impl.adt;

import es.ua.dlsi.grfia.moosicae.core.adt.IFraction;

/**
 * Adaptar class used to avoid coupling our implementation to the Apache library.
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/1/21
 */
public class Fraction implements IFraction {
    public static final IFraction ZERO = new Fraction(org.apache.commons.lang3.math.Fraction.ZERO);
    public static final IFraction MAX = new Fraction(Integer.MAX_VALUE, 1);
    public static final IFraction ONE_HALF = new Fraction(1, 2);

    private final org.apache.commons.lang3.math.Fraction fraction;

    public Fraction(org.apache.commons.lang3.math.Fraction fraction) {
        this.fraction = fraction;
    }

    public Fraction(int numerator, int denominator) {
        this.fraction = org.apache.commons.lang3.math.Fraction.getFraction(numerator, denominator);
    }

    public Fraction(double numerator) {
        this.fraction = org.apache.commons.lang3.math.Fraction.getFraction(numerator);
    }

    public static IFraction getFraction(int numerator, int denominator) {
        return new Fraction(org.apache.commons.lang3.math.Fraction.getFraction(numerator, denominator));
    }

    @Override
    public IFraction reduce() {
        return new Fraction(fraction.reduce());
    }

    @Override
    public double doubleValue() {
        return fraction.doubleValue();
    }

    @Override
    public IFraction add(double value) {
        return new Fraction(fraction.add(org.apache.commons.lang3.math.Fraction.getFraction(value)));
    }

    @Override
    public IFraction add(IFraction value) {
        return new Fraction(fraction.add(((Fraction)value).fraction));
    }

    @Override
    public IFraction subtract(double value) {
        return new Fraction(fraction.subtract(org.apache.commons.lang3.math.Fraction.getFraction(value)));
    }

    @Override
    public IFraction subtract(IFraction value) {
        return new Fraction(fraction.subtract(((Fraction)value).fraction));
    }

    @Override
    public IFraction multiplyBy(IFraction value) {
        return new Fraction(fraction.multiplyBy(((Fraction)value).fraction));
    }

    @Override
    public IFraction multiplyBy(double value) {
        return new Fraction(fraction.multiplyBy(org.apache.commons.lang3.math.Fraction.getFraction(value)));
    }

    @Override
    public IFraction divideBy(IFraction value) {
        return new Fraction(fraction.divideBy(((Fraction)value).fraction));
    }

    @Override
    public IFraction divideBy(double value) {
        return new Fraction(fraction.divideBy(org.apache.commons.lang3.math.Fraction.getFraction(value)));
    }

    @Override
    public int getNumerator() {
        return fraction.getNumerator();
    }

    @Override
    public int intValue() {
        return fraction.intValue();
    }

    @Override
    public int compareTo(IFraction o) {
        return fraction.compareTo(((Fraction)o).fraction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;

        Fraction fraction1 = (Fraction) o;

        return fraction.equals(fraction1.fraction);
    }

    @Override
    public int hashCode() {
        return fraction.hashCode();
    }
}
