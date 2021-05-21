package es.ua.dlsi.grfia.moosicae.core.scoregraph;

import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.core.impl.scoregraph.ScoreGraphNode;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/5/21
 */
public interface IScoreGraphContentNode extends IScoreGraphNode {
    IScoreGraphNode getPrevNode(IScoreSubgraph subgraph);
    IMooObject getContent();
}
