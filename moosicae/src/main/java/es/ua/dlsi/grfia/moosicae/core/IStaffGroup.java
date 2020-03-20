package es.ua.dlsi.grfia.moosicae.core;

/**
 * Designed using a composite pattern, this is the composite component
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IStaffGroup extends ISystemElement {
    ISystemElement[] getChildren();
    void add(ISystemElement child);
}
