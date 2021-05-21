package es.ua.dlsi.grfia.moosicae.core.scoregraph;

import es.ua.dlsi.grfia.moosicae.core.IPart;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/5/21
 */
public interface IScorePartSubgraph extends IScoreSubgraph {
    IScoreVoiceSubgraph[] getVoicesSubgraphs();
    void addVoiceSubgraph(IScoreVoiceSubgraph voiceSubgraph);
    IPart getPart();
}
