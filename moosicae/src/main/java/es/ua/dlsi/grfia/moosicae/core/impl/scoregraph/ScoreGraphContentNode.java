package es.ua.dlsi.grfia.moosicae.core.impl.scoregraph;

import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreGraphContentNode;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreGraphNode;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreSubgraph;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/5/21
 */
public class ScoreGraphContentNode extends ScoreGraphNode implements IScoreGraphContentNode {
    final IMooObject content;
    HashMap<IScoreSubgraph, IScoreGraphNode> prevNodes;

    public ScoreGraphContentNode(IMooObject content) {
        this.content = content;
        this.prevNodes = new HashMap<>();
    }


    @Override
    public IScoreGraphNode getPrevNode(IScoreSubgraph subgraph) {
        return this.prevNodes.get(subgraph);
    }

    public void setPrevNode(IScoreSubgraph subgraph, IScoreGraphNode prevNode) {
        this.prevNodes.put(subgraph, prevNode);
    }

    @Override
    public IMooObject getContent() {
        return content;
    }

    void linkFromPreviousNode(IScoreSubgraph subgraph, ScoreGraphNode scoreGraphNode) {
        this.prevNodes.put(subgraph, scoreGraphNode);
    }

    @Override
    public String toDotLabelString() {
        return content.getClass().getName();
    }
}
