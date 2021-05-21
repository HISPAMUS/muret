package es.ua.dlsi.grfia.moosicae.core.impl.scoregraph;

import es.ua.dlsi.grfia.moosicae.core.IVoice;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreVoiceSubgraph;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/5/21
 */
public class ScoreVoiceSubgraph extends ScoreSubgraph implements IScoreVoiceSubgraph {
    private final IVoice voice;

    public ScoreVoiceSubgraph(IVoice voice) {
        this.voice = voice;
    }

    @Override
    public IVoice getVoice() {
        return voice;
    }

    @Override
    public String toDotLabelString() {
        return "Voice " + voice.getName();
    }
}
