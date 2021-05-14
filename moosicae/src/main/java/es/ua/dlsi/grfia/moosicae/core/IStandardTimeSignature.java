package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.ITimeSignatureDenominator;
import es.ua.dlsi.grfia.moosicae.core.properties.ITimeSignatureNumerator;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public interface IStandardTimeSignature extends IMeter {
    ITimeSignatureNumerator getNumerator();
    ITimeSignatureDenominator getDenominator();
}
