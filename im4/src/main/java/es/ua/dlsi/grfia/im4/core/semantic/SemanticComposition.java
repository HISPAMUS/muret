package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;
import es.ua.dlsi.grfia.im4.core.adt.dag.DAG;
import es.ua.dlsi.grfia.im4.core.adt.dag.DAGItem;
import es.ua.dlsi.grfia.im4.core.adt.dag.DAGNode;

import java.util.HashMap;

/**
 * The main entry point: a musical piece, a musical composition.
 * The spines graph is started from the startItem
 * @author drizo
 */
public class SemanticComposition {
    /**
     * The data type must be encapsulated
     */
    private final DAG<SemanticItem> dag;
    /**
     * Used to encapsulate the DAG (see add method)
     */
    private final HashMap<SemanticItem, DAGNode<SemanticItem>> insertedNodes;

    private CompositionStartItem startItem;

    public SemanticComposition() {
        this.dag = new DAG<>();
        this.insertedNodes = new HashMap<>();
        startItem = new CompositionStartItem();
        add(null, startItem);
    }

    public void add(SemanticItem previousItem, SemanticItem semanticItem) {
        DAGNode<SemanticItem> previousNode = null;
        if (previousItem != null) {
            previousNode = this.insertedNodes.get(previousItem);
            if (previousNode == null) {
                throw new IM4RuntimeException("The previous item " + previousItem + " cannot be found in the insertedNodes hash map");
            }
        }
        DAGItem<SemanticItem> newNode = new DAGItem<>(semanticItem);
        this.dag.add(previousNode, newNode);
    }

    public void addHeader(HeaderItem headerItem) {
        add(startItem, headerItem);
    }
}
