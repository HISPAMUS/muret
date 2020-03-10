package es.ua.dlsi.grfia.im4.core;

public interface IScore {
    IMetadata getMetadata();
    IPart[] getParts();
    IStaves[] getStaves();
    void addPart(IPart part);
    void addStaves(IStaves staves);
}
