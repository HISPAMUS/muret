package es.ua.dlsi.grfia.moosicae.core;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IScore extends ICoreObject{
    IMetadata getMetadata();
    IPart[] getParts();
    ISystem[] getSystemElements();
    IStaff[] getAllStaves();
    void add(IPart part);
    void add(ISystem staves);
    void moveVoice(IVoice voice, IPart fromPart, IPart toPart);
    void remove(IPart part);

    /**
     * It adds the symbol to the voice and puts in in the staff
     * @param toVoice
     * @param inStaff
     * @param symbol
     */
    void add(IVoice toVoice, IStaff inStaff, ICoreItem symbol);
}
