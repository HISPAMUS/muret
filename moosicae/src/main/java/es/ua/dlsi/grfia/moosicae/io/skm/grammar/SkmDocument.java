package es.ua.dlsi.grfia.moosicae.io.skm.grammar;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens.SkmHeader;
import es.ua.dlsi.grfia.moosicae.utils.dag.DAG;
import es.ua.dlsi.grfia.moosicae.utils.dag.DAG2DotExporter;
import es.ua.dlsi.grfia.moosicae.utils.dag.DAGLabel;
import es.ua.dlsi.grfia.moosicae.utils.dag.DAGNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * The main entry point: a musical piece, a musical composition.
 * The spines graph is started from the startToken
 * @author David Rizo - drizo@dlsi.ua.es
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

    private SkmToken startToken;

    public SkmDocument() {
        this.dag = new DAG<>();
        this.insertedNodes = new HashMap<>();
        startToken = new SkmToken("");
        try {
            add(null, startToken);
        } catch (IMException e) {
            throw new IMRuntimeException("This situation should be impossible", e);
        }
    }

    private DAGNode<SkmToken> findExistingNode(SkmToken token) {
        DAGNode<SkmToken> result = this.insertedNodes.get(token);
        if (result == null) {
            throw new IMRuntimeException("The previous item " + token + " cannot be found in the insertedNodes hash map");
        }
        return result;
    }

    public void add(SkmToken previousToken, SkmToken skmToken) throws IMException {
        DAGNode<SkmToken> previousNode = null;
        if (previousToken != null) {
            previousNode = findExistingNode(previousToken);
        }
        if (previousNode != null && previousNode.getLabel() != null && previousNode.getLabel().getContent() == skmToken) { // same object
            throw new IMException("The skmToken " + skmToken + " was already inserted, and the DAG does not allow loops");
        }
        DAGNode newNode = this.dag.add(previousNode, new DAGLabel<>(skmToken));
        this.insertedNodes.put(skmToken, newNode);
    }

    public void addHeader(SkmHeader headerToken) throws IMException {
        add(startToken, headerToken);
    }

    public void printGraphDot(File file) throws FileNotFoundException {
        DAG2DotExporter dag2DotExporter = new DAG2DotExporter();
        dag2DotExporter.export(file, dag);
    }

    public IScore buildScore(ICoreAbstractFactory abstractFactory) throws IMException {
        return new SkmDocument2IScore(abstractFactory).convert(dag.getFirstNode());
    }

    public List<SkmToken> getHeaderTokens() {
        List<SkmToken> result = new LinkedList<>();

        for (DAGNode<SkmToken> node: this.dag.getFirstNode().getNextList()) {
            result.add(node.getLabel().getContent());
        }
        return result;
    }

    public List<SkmToken> getNextList(SkmToken token) {
        DAGNode<SkmToken> node = findExistingNode(token);
        List<SkmToken> result = new LinkedList<>();
        for (DAGNode<SkmToken> next: node.getNextList()) {
            result.add(next.getLabel().getContent());
        }
        return result;
    }
}
