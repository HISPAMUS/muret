package es.ua.dlsi.grfia.moosicae.core;

public interface IScore {
    IMetadata getMetadata();
    IPart[] getParts();
    IStaffOurGroup[] getStaffOurGroups();
    IStaff[] getAllStaves();
    void add(IPart part);
    void add(IStaffOurGroup staves);
}
