package es.ua.dlsi.grfia.moosicae.utils.dag;

import es.ua.dlsi.grfia.moosicae.IMRuntimeException;

/**
 * Directed acyclic graph
 * @param <SpineItemContentType> The type of the elements that will be stored in the items
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class DAG<SpineItemContentType> {
    DAGNode<SpineItemContentType> firstNode;

    public DAG() {
    }

    public DAGNode add(DAGNode<SpineItemContentType> previous, DAGLabel<SpineItemContentType> item) {
        if (firstNode == null) {
            if (previous != null) {
                throw new IMRuntimeException("Cannot add a node to a previous node when the first node is null");
            }
            firstNode = new DAGNode<>(item);
            return firstNode;
        } else {
            DAGNode<SpineItemContentType> node = new DAGNode<>(item);
            node.setPrevious(previous);
            previous.addNext(node);
            return node;
        }
    }


    public DAGNode<SpineItemContentType> getFirstNode() {
        return firstNode;
    }
}
