package es.ua.dlsi.grfia.moosicae.core;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public interface ICommonAlterationKey extends IKey {
    int getAccidentalCount();
    Optional<IAccidentalSymbol> getAccidentalSymbol();
}
