package es.ua.dlsi.grfia.moosicae.core.scoregraph;

import es.ua.dlsi.grfia.moosicae.core.IMooObject;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/5/21
 */
public interface IScoreGraphNode {
    IScoreGraphContentNode[] getNextNodes(IScoreSubgraph subgraph);
    void linkWithNextNode(IScoreSubgraph subgraph, IScoreGraphContentNode nextNode);
}
