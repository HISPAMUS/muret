package es.ua.dlsi.grfia.moosicae.core.adt;

import es.ua.dlsi.grfia.moosicae.core.impl.adt.FractionBuilder;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/1/21
 */
public interface IFractionBuilder {
    /**
     * Static by default
     */
    IFractionBuilder instance = new FractionBuilder();
    static IFractionBuilder getInstance() {
        return instance;
    }

    IFraction getZero();
    IFraction getMax();
    IFraction build(int numerator, int denominator);
    IFraction build(int numerator);
    IFraction getOneHalf();
}
