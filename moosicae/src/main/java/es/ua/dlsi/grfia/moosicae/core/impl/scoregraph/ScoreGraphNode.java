package es.ua.dlsi.grfia.moosicae.core.impl.scoregraph;

import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreGraphContentNode;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreGraphNode;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreSubgraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/5/21
 */
public abstract class ScoreGraphNode implements IScoreGraphNode {
    HashMap<ScoreSubgraph, List<ScoreGraphContentNode>> nextNodes;

    public ScoreGraphNode() {
        this.nextNodes = null;
    }

    @Override
    public IScoreGraphContentNode[] getNextNodes(IScoreSubgraph subgraph) {
        if (this.nextNodes == null) {
            return new IScoreGraphContentNode[0];
        } else {
            List<ScoreGraphContentNode> next = this.nextNodes.get(subgraph);
            if (next == null) {
                return new IScoreGraphContentNode[0];
            } else {
                return next.toArray(new IScoreGraphContentNode[0]);
            }
        }
    }

    /**
     * Package visibility
     * @return
     */
    HashMap<ScoreSubgraph, List<ScoreGraphContentNode>> getNextNodes() {
        return nextNodes;
    }

    @Override
    public void linkWithNextNode(IScoreSubgraph subgraph, IScoreGraphContentNode nextNode) {
        if (this.nextNodes == null) {
            this.nextNodes = new HashMap<>();
        }

        List<ScoreGraphContentNode> next = this.nextNodes.get(subgraph);
        if (next == null) {
            next = new LinkedList<>();
            this.nextNodes.put((ScoreSubgraph) subgraph, next);
        }
        ((ScoreGraphContentNode)nextNode).linkFromPreviousNode(subgraph, this);
        next.add((ScoreGraphContentNode) nextNode);
    }

    public abstract String toDotLabelString();
}
