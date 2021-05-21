package es.ua.dlsi.grfia.moosicae.core.scoregraph;

import es.ua.dlsi.grfia.moosicae.core.IVoice;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/5/21
 */
public interface IScoreVoiceSubgraph extends IScoreSubgraph {
    IVoice getVoice();
}
