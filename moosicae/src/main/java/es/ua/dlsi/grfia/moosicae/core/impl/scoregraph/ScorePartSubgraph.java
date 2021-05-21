package es.ua.dlsi.grfia.moosicae.core.impl.scoregraph;

import es.ua.dlsi.grfia.moosicae.core.IPart;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScorePartSubgraph;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreVoiceSubgraph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/5/21
 */
public class ScorePartSubgraph extends ScoreSubgraph implements IScorePartSubgraph {
    private final IPart part;
    private final List<IScoreVoiceSubgraph> voiceSubgraphs;

    public ScorePartSubgraph(IPart part) {
        this.part = part;
        this.voiceSubgraphs = new LinkedList<>();
    }

    @Override
    public IScoreVoiceSubgraph[] getVoicesSubgraphs() {
        return this.voiceSubgraphs.toArray(new IScoreVoiceSubgraph[0]);
    }

    @Override
    public void addVoiceSubgraph(IScoreVoiceSubgraph voiceSubgraph) {
        this.voiceSubgraphs.add(voiceSubgraph);
    }

    @Override
    public IPart getPart() {
        return part;
    }

    @Override
    public String toDotLabelString() {
        return "part " + part.getName();
    }
}
