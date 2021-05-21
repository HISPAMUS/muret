package es.ua.dlsi.grfia.moosicae.core.impl.scoregraph;

import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreSubgraph;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/5/21
 */
public abstract class ScoreSubgraph implements IScoreSubgraph {
    public abstract String toDotLabelString();
}
