package es.ua.dlsi.grfia.moosicae.core.impl.scoregraph;

import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreGraphNode;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreGraphStartNode;
import es.ua.dlsi.grfia.moosicae.utils.dag.DAGNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 20/5/21
 */
public class ScoreGraph2DotExporter {
    private HashSet<ScoreGraphNode> exportedNodes;

    private void printNodes(PrintStream os, ScoreGraphNode scoreGraphNode) {
        if (!exportedNodes.contains(scoreGraphNode)) {
            exportedNodes.add(scoreGraphNode);
            String escapedLabel = scoreGraphNode.toDotLabelString().replaceAll("\"", "\\\""); // change " for \"
            os.println("s" + scoreGraphNode.hashCode() + "[label=\"" + escapedLabel + "\", shape=circle];");
            if (scoreGraphNode.nextNodes != null) {
                for (List<ScoreGraphContentNode> nexts : scoreGraphNode.nextNodes.values()) {
                    for (ScoreGraphContentNode next : nexts) {
                        printNodes(os, next);
                    }
                }
            }
        }
    }

    private void printEdges(PrintStream os, ScoreGraphNode scoreGraphNode) {
        if (scoreGraphNode.nextNodes != null) {
            scoreGraphNode.nextNodes.forEach((scoreSubgraph, scoreGraphContentNodes) -> {
                if (scoreGraphContentNodes != null) {
                    for (ScoreGraphContentNode next : scoreGraphContentNodes) {
                        String label = scoreSubgraph.toDotLabelString();
                        os.println("s" + scoreGraphNode.hashCode() + "->s" + next.hashCode() + "[label=\"" + label + "\"];");
                        printEdges(os, next);
                    }
                }
            });
        }
    }

    public void export(File file, ScoreGraph scoreGraph) throws FileNotFoundException {
        exportedNodes = new HashSet<>();
        PrintStream os = new PrintStream(new FileOutputStream(file));
        os.println("digraph dfa {");

        ScoreGraphStartNode firstNode = (ScoreGraphStartNode) scoreGraph.getStartNode();

        if (firstNode != null) {
            // first add all nodes
            printNodes(os, firstNode);
            // now the edges
            printEdges(os, firstNode);
        }
        os.println("}");
        if (os != null) {
            os.close();
        }
    }
}
