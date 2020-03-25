package es.ua.dlsi.grfia.moosicae.core;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public interface IFractionalTimeSignature extends IMeter {
    ITimeSignatureNumerator getNumerator();
    ITimeSignatureDenominator getDenominator();
}
