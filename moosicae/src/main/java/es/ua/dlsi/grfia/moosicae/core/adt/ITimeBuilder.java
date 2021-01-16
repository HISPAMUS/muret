package es.ua.dlsi.grfia.moosicae.core.adt;


import es.ua.dlsi.grfia.moosicae.core.impl.adt.TimeBuilder;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/1/21
 */
public interface ITimeBuilder {
    /**
     * Static by default
     */
    ITimeBuilder instance = new TimeBuilder();
    static ITimeBuilder getInstance() {
        return instance;
    }
    ITime build();
    ITime build(IFraction fraction);
    ITime build(int numerator, int denominator);
    ITime timeZero();
    ITime timeMax();


}
