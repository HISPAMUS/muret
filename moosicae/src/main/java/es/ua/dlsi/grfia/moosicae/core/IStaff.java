package es.ua.dlsi.grfia.moosicae.core;

/**
 * Designed using a composite pattern, this is the leaf class
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IStaff extends ISystemElement {
    int getNumber();
    ISymbol[] getStaffSymbols();

    /**
     * Add a page or system beginning
     * @param staffLayoutElement
     */
    void addLayoutElement(IStaffLayoutElement staffLayoutElement);

    void put(ISymbol symbol);

    void remove(ISymbol symbol);
}
