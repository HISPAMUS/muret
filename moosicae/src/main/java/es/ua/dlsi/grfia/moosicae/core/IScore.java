package es.ua.dlsi.grfia.moosicae.core;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IScore extends IMooObject {
    IMetadata getMetadata();
    IPart[] getParts();

    /**
     * Systems in the array are ordered from top to bottom: e.g., in a STAB score, the S = 0, A = 1, T = 2, B = 3
     * @return
     */
    ISystem[] getSystemElements();

    //TODO
    /**
     * @deprecated ¿No debería ser el system elements?
     * @return
     */
    IStaff[] listAllStaves();
    void add(IPart part);
    void add(ISystem systemElement);
    void remove(ISystem systemElement);
    void moveVoice(IVoice voice, IPart fromPart, IPart toPart);
    void remove(IPart part);

    /**
     * It adds the symbol to the voice and puts in in the staff
     * @param toVoice
     * @param inStaff
     * @param symbol
     */
    void add(IVoice toVoice, IStaff inStaff, IVoicedItem symbol);

    IMeasure[] getMeasures();
    void add(IMeasure measure);
}
