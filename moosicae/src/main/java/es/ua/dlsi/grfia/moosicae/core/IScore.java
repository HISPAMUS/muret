package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreGraph;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IScore extends IMooObject {
    IScoreGraph getScoreGraph();

    /////////TODO Revisar de aquí a bajo de forma coherente con el grafo
    IMetadata getMetadata();

    /**
     * @deprecated Use getScoreGraph
     * @return
     */
    IPart[] getParts();

    /**
     * @deprecated Usr graph
     * Systems in the array are ordered from top to bottom: e.g., in a STAB score, the S = 0, A = 1, T = 2, B = 3
     * @return
     */
    ISystem[] getSystemElements();

    /**
     * @deprecated Use getScoreGraph
     * @return
     */
    IStaff[] listAllStaves();
    /**
     * @deprecated Use getScoreGraph
     */
    void add(IPart part);
    /**
     * @deprecated Use getScoreGraph
     * @return
     */
    void add(ISystem systemElement);
    /**
     * @deprecated Use getScoreGraph
     * @return
     */
    void remove(ISystem systemElement);
    /**
     * @deprecated Use getScoreGraph
     * @return
     */
    void moveVoice(IVoice voice, IPart fromPart, IPart toPart);
    /**
     * @deprecated Use getScoreGraph
     * @return
     */
    void remove(IPart part);

    /**
     * @deprecated Use getScoreGraph
     * Utility convenience method, it adds the symbol to the voice and puts in in the staff
     * @param toVoice
     * @param inStaff
     * @param symbol
     */
    void add(IVoice toVoice, IStaff inStaff, IVoicedSingle symbol);

    /**
     * @deprecated Use getScoreGraph
     * @return
     */
    IMeasure[] getMeasures();

    /**
     * @deprecated Use getScoreGraph
     * @param measure
     */
    void add(IMeasure measure);
}
