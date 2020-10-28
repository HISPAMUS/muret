package es.ua.dlsi.grfia.moosicae.io.kern.grammar;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens.KernHeader;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens.KernSpineBegin;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens.KernSpineSplit;
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
 * The spines graph is started from the startToken.
 * When a spine is split, added, joint, or terminated, a special token is added:
 * - all spines are started with a KernSpineBegin token (the KernHeader are descendants of KernSpineBegin)
 * - when a split is found, two tokens are added as successor of the last item: the KernSpineSplit token itself, and a new KernSpineBegin (sibling of the KernSpineSplit)
 * TODO - Por aquí
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KernDocument {
    /**
     * The data type must be encapsulated
     */
    private final DAG<KernToken> dag;
    /**
     * Used to encapsulate the DAG (see add method)
     */
    private final HashMap<KernToken, DAGNode<KernToken>> insertedNodes;

    private KernToken startToken;

    public KernDocument() {
        this.dag = new DAG<>();
        this.insertedNodes = new HashMap<>();
        startToken = new KernToken("");
        try {
            add(null, startToken);
        } catch (IMException e) {
            throw new IMRuntimeException("This situation should be impossible", e);
        }
    }

    private DAGNode<KernToken> findExistingNode(KernToken token) {
        DAGNode<KernToken> result = this.insertedNodes.get(token);
        if (result == null) {
            throw new IMRuntimeException("The previous item " + token + " cannot be found in the insertedNodes hash map");
        }
        return result;
    }

    public void add(KernToken previousToken, KernToken skmToken) throws IMException {
        DAGNode<KernToken> previousNode = null;
        if (previousToken != null) {
            previousNode = findExistingNode(previousToken);
        }
        if (previousNode != null && previousNode.getLabel() != null && previousNode.getLabel().getContent() == skmToken) { // same object
            throw new IMException("The skmToken " + skmToken + " was already inserted, and the DAG does not allow loops");
        }
        DAGNode newNode = this.dag.add(previousNode, new DAGLabel<>(skmToken));
        this.insertedNodes.put(skmToken, newNode);
    }

    public void addHeader(KernHeader headerToken) throws IMException {
        add(startToken, headerToken);
    }

    /**
     *
     * @param previousToken
     * @param spineSplit
     * @return The new parallel spine created as sibling of the spineSplit
     * @throws IMException
     */
    public KernSpineBegin addSplitSpine(KernToken previousToken, KernSpineSplit spineSplit) throws IMException {
        KernSpineBegin newSpineBegin = new KernSpineBegin();
        add(previousToken, spineSplit);
        add(previousToken, newSpineBegin);
        return newSpineBegin;
    }

    public void printGraphDot(File file) throws FileNotFoundException {
        DAG2DotExporter dag2DotExporter = new DAG2DotExporter();
        dag2DotExporter.export(file, dag);
    }

    public IScore buildScore(ICoreAbstractFactory abstractFactory) throws IMException {
        return new KernDocument2IScore(abstractFactory).convert(dag.getFirstNode());
    }

    public List<KernToken> getHeaderTokens() {
        List<KernToken> result = new LinkedList<>();

        for (DAGNode<KernToken> node: this.dag.getFirstNode().getNextList()) {
            result.add(node.getLabel().getContent());
        }
        return result;
    }

    public List<KernToken> getNextList(KernToken token) {
        DAGNode<KernToken> node = findExistingNode(token);
        List<KernToken> result = new LinkedList<>();
        for (DAGNode<KernToken> next: node.getNextList()) {
            result.add(next.getLabel().getContent());
        }
        return result;
    }
}
