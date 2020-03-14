package es.ua.dlsi.grfia.moosicae.core;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IScore {
    IMetadata getMetadata();
    IPart[] getParts();
    ISystemElement[] getSystemElements();
    IStaff[] getAllStaves();
    void add(IPart part);
    void add(ISystemElement staves);
    void moveVoice(IVoice voice, IPart fromPart, IPart toPart);
}
