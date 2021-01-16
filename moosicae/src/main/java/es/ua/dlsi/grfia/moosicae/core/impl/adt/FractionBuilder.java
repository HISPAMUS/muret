package es.ua.dlsi.grfia.moosicae.core.impl.adt;

import es.ua.dlsi.grfia.moosicae.core.adt.IFraction;
import es.ua.dlsi.grfia.moosicae.core.adt.IFractionBuilder;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/1/21
 */
public class FractionBuilder implements IFractionBuilder {
    public FractionBuilder() {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Initializing dependency injection for IFractionBuilder");
    }

    @Override
    public IFraction getZero() {
        return Fraction.ZERO;
    }

    @Override
    public IFraction getMax() {
        return Fraction.MAX;
    }

    @Override
    public IFraction build(int numerator, int denominator) {
        return new Fraction(numerator, denominator);
    }

    @Override
    public IFraction build(int numerator) {
        return new Fraction(numerator);
    }

    @Override
    public IFraction getOneHalf() {
        return Fraction.ONE_HALF;
    }
}
