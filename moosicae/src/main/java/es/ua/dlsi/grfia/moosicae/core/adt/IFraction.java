package es.ua.dlsi.grfia.moosicae.core.adt;

import es.ua.dlsi.grfia.moosicae.core.impl.adt.Fraction;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/1/21
 */
public interface IFraction extends Comparable<IFraction> {
    IFraction reduce();
    double doubleValue();
    IFraction add(double value);
    IFraction add(IFraction value);
    IFraction subtract(double value);
    IFraction subtract(IFraction value);
    IFraction multiplyBy(IFraction value);
    IFraction multiplyBy(double value);
    IFraction divideBy(IFraction value);
    IFraction divideBy(double value);
    int getNumerator();
    int intValue();
}
