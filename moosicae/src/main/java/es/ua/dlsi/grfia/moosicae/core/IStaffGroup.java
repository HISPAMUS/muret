package es.ua.dlsi.grfia.moosicae.core;

/**
 * Designed using a composite pattern, this is the composite component
 */
public interface IStaffGroup extends IStaffOurGroup {
    IStaffOurGroup[] getChildren();
    void add(IStaffOurGroup child);
}
