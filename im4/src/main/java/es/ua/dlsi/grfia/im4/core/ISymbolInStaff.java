package es.ua.dlsi.grfia.im4.core;

/**
 * Used this wrapper because the symbol may be located in different staves (one for a parts score, other for the whole score)
 */
public interface ISymbolInStaff extends IStaffSymbol {
    ISymbol getSymbol();
}
