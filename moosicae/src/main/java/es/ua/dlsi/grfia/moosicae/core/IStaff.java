package es.ua.dlsi.grfia.moosicae.core;

/**
 * Designed using a composite pattern, this is the leaf class
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IStaff extends ISystemElement {
    ICoreItem[] getStaffSymbols();

    /**
     * Add a page or system beginning
     * @param staffLayoutElement
     */
    void addLayoutElement(IStaffLayoutElement staffLayoutElement);

    void put(ICoreItem symbol);

    void remove(ICoreItem symbol);
}
