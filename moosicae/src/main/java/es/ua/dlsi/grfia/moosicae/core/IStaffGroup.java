package es.ua.dlsi.grfia.moosicae.core;

/**
 * Designed using a composite pattern, this is a (restricted because it's not recursive) composite component
 */
public interface IStaffGroup extends IStaves {
    IStaff[] getStaves();
}
