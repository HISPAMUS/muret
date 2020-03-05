package es.ua.dlsi.grfia.im4.io.skm;

import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;
import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmHeader;
import es.ua.dlsi.grfia.im4.utils.dag.DAG;
import es.ua.dlsi.grfia.im4.utils.dag.DAG2DotExporter;
import es.ua.dlsi.grfia.im4.utils.dag.DAGLabel;
import es.ua.dlsi.grfia.im4.utils.dag.DAGNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * The main entry point: a musical piece, a musical composition.
 * The spines graph is started from the startToken
 * @author drizo
 */
public class SkmDocument {
    /**
     * The data type must be encapsulated
     */
    private final DAG<SkmToken> dag;
    /**
     * Used to encapsulate the DAG (see add method)
     */
    private final HashMap<SkmToken, DAGNode<SkmToken>> insertedNodes;

    private CompositionStartToken startToken;

    public SkmDocument() {
        this.dag = new DAG<>();
        this.insertedNodes = new HashMap<>();
        startToken = new CompositionStartToken();
        add(null, startToken);
    }

    public void add(SkmToken previousToken, SkmToken skmToken) {
        DAGNode<SkmToken> previousNode = null;
        if (previousToken != null) {
            previousNode = this.insertedNodes.get(previousToken);
            if (previousNode == null) {
                throw new IM4RuntimeException("The previous item " + previousToken + " cannot be found in the insertedNodes hash map");
            }
        }
        DAGNode newNode = this.dag.add(previousNode, new DAGLabel<>(skmToken));
        this.insertedNodes.put(skmToken, newNode);
    }

    public void addHeader(SkmHeader headerToken) {
        add(startToken, headerToken);
    }

    public void printGraphDot(File file) throws FileNotFoundException {
        DAG2DotExporter dag2DotExporter = new DAG2DotExporter();
        dag2DotExporter.export(file, dag);
    }
}
