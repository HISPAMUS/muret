package es.ua.dlsi.grfia.moosicae.core;

/**
 * Used this wrapper because the symbol may be located in different staves (one for a parts score, other for the whole score)
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IStaffElementOfSymbol extends IStaffElement {
    ISymbol getSymbol();
}
