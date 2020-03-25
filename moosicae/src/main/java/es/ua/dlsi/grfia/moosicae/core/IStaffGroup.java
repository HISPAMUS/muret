package es.ua.dlsi.grfia.moosicae.core;

/**
 * Designed using a composite pattern, this is the composite component.
 * This staff group can constitute a main system or a subsystem
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IStaffGroup extends ISystem {
    ISystem[] getChildren();
    void add(ISystem child);
}
