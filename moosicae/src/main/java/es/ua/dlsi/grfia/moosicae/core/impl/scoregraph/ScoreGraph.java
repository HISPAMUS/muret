package es.ua.dlsi.grfia.moosicae.core.impl.scoregraph;

import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * The nodes are implementing a double linked list. The same contents are shared among nodes in different graphs
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/5/21
 */
public class ScoreGraph implements IScoreGraph {
    private final List<IScorePartSubgraph> partSubgraphs; //TODO
    private final HashMap<IScoreStaffSubgraph, IScoreGraphNode> lastStaffNode;
    private ScoreGraphStartNode startNode;

    public ScoreGraph() {
        this.partSubgraphs = new LinkedList<>();
        this.lastStaffNode = new HashMap<>();
        this.startNode = new ScoreGraphStartNode();
    }

    @Override
    public IScorePartSubgraph[] getPartsSubgraphs() {
        return this.partSubgraphs.toArray(new IScorePartSubgraph[0]);
    }

    @Override
    public void addPartSubgraph(IScorePartSubgraph subgraph) {
        this.partSubgraphs.add(subgraph);
    }

    @Override
    public IScoreStaffSubgraph[] getStavesSubgraphs() {
        return this.lastStaffNode.keySet().toArray(new IScoreStaffSubgraph[0]);
    }

    @Override
    public void addStaffSubgraph(IScoreStaffSubgraph subgraph) {
        this.lastStaffNode.put(subgraph, startNode);
    }

    @Override
    public void addCommonContentNode(IMooObject mooObject) {
        ScoreGraphContentNode contentNode = new ScoreGraphContentNode(mooObject);
        this.lastStaffNode.forEach((staffSubgraph, lastNode) -> {
            lastNode.linkWithNextNode(staffSubgraph, contentNode);
        });
        for (IScoreStaffSubgraph subgraph: lastStaffNode.keySet()) {
            lastStaffNode.put(subgraph, contentNode);
        }
    }

    @Override
    public void addContentNode(IScoreStaffSubgraph subgraph, IMooObject mooObject) {
        ScoreGraphContentNode contentNode = new ScoreGraphContentNode(mooObject);
        IScoreGraphNode lastNode = this.lastStaffNode.get(subgraph);
        if (lastNode == null) {
            throw new IMRuntimeException("There should be a last node in subgraph " + subgraph);
        }
        lastNode.linkWithNextNode(subgraph, contentNode);
        lastStaffNode.put(subgraph, contentNode);
    }

    @Override
    public IScoreGraphStartNode getStartNode() {
        return this.startNode;
    }

    @Override
    public void printDot(File file) throws FileNotFoundException {
        ScoreGraph2DotExporter scoreGraph2DotExporter = new ScoreGraph2DotExporter();
        scoreGraph2DotExporter.export(file, this);
    }
}
