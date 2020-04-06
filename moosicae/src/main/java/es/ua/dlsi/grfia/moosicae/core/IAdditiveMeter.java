package es.ua.dlsi.grfia.moosicae.core;

/**
 * Same denominator and several numerators: e.g. (3+2)/4
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 04/04/2020
 */
public interface IAdditiveMeter extends IMeter {
    ITimeSignatureNumerator[] getNumerators();
    ITimeSignatureDenominator getDenominator();
}
