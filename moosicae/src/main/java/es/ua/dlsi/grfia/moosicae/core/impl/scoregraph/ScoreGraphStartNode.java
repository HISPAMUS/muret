package es.ua.dlsi.grfia.moosicae.core.impl.scoregraph;

import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreGraphStartNode;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/5/21
 */
public class ScoreGraphStartNode extends ScoreGraphNode implements IScoreGraphStartNode {
    @Override
    public String toDotLabelString() {
        return "start";
    }
}
