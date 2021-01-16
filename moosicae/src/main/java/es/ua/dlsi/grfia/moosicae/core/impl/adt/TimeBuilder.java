package es.ua.dlsi.grfia.moosicae.core.impl.adt;

import es.ua.dlsi.grfia.moosicae.core.adt.IFraction;
import es.ua.dlsi.grfia.moosicae.core.adt.IFractionBuilder;
import es.ua.dlsi.grfia.moosicae.core.adt.ITime;
import es.ua.dlsi.grfia.moosicae.core.adt.ITimeBuilder;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/1/21
 */
public class TimeBuilder implements ITimeBuilder {
    private static final Time ZERO = new Time(Fraction.ZERO);
    private static final Time MAX = new Time(Fraction.MAX);

    public TimeBuilder() {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Initializing dependency injection for ITimeBuilder");
    }

    @Override
    public ITime build() {
        return new Time();
    }

    @Override
    public ITime build(IFraction fraction) {
        return new Time(fraction);
    }

    @Override
    public ITime build(int numerator, int denominator) {
        return new Time(numerator, denominator);
    }

    @Override
    public ITime timeZero() {
        return ZERO;
    }

    @Override
    public ITime timeMax() {
        return MAX;
    }
}
