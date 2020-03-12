package es.ua.dlsi.grfia.moosicae.core;

public interface IScore {
    IMetadata getMetadata();
    IPart[] getParts();
    ISystemElement[] getSystemElements();
    IStaff[] getAllStaves();
    void add(IPart part);
    void add(ISystemElement staves);
}
