package es.ua.dlsi.grfia.im4.core.adt.dag;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class DAG2DotExporter<SpineItemContentType> {
    private void printNodes(PrintStream os, DAGNode<SpineItemContentType> dagNode) {
        if (dagNode.getItem() != null) {
            String escapedLabel = dagNode.getItem().toString().replaceAll("\"","\\\""); // change " for \"
            os.println("s" + dagNode.getUniqueID() + "[label=\"" +escapedLabel + "\", shape=circle];");
        } else {
            os.println("s" + dagNode.getUniqueID() + ";");
        }

        for (DAGNode<SpineItemContentType> next: dagNode.getNextList()) {
            printNodes(os, next);
        }
    }

    private void printEdges(PrintStream os, DAGNode<SpineItemContentType> dagNode) {
        for (DAGNode<SpineItemContentType> next: dagNode.getNextList()) {
            os.println("s" + dagNode.getUniqueID() + "->s" + next.getUniqueID() + ";");
            printEdges(os, next);
        }
    }

    public void export(File file, DAG<SpineItemContentType> dag) throws FileNotFoundException {
        PrintStream os = new PrintStream(new FileOutputStream(file));
        os.println("digraph dfa {");

        DAGNode<SpineItemContentType> firstNode = dag.getFirstNode();

        if (firstNode != null) {
            // first add all nodes
            printNodes(os, firstNode);
            // not the edges
            printEdges(os, firstNode);
        }
        os.println("}");
        if (os != null) {
            os.close();
        }
    }
}
