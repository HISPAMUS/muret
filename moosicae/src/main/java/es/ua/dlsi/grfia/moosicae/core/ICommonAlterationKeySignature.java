package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IAccidentalSymbol;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public interface ICommonAlterationKeySignature extends IKey {
    int getAccidentalCount();
    Optional<IAccidentalSymbol> getAccidentalSymbol();
}
