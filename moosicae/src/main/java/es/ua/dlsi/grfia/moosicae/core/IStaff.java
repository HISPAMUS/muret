package es.ua.dlsi.grfia.moosicae.core;

/**
 * Designed using a composite pattern, this is the leaf class
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IStaff extends ISystemElement {
    int getNumber();
    IStaffElement[] getStaffSymbols();

    /**
     * Add a page or system beginning
     * @param staffLayoutElement
     */
    void addLayoutElement(IStaffLayoutElement staffLayoutElement);

    /**
     * Wrap a symbol inside a IStaffElementOfSymbol placeholder and add to the staff
     * @param symbol
     * @return
     */
    IStaffElementOfSymbol put(ISymbol symbol);

    void remove(ISymbol symbol);
}
