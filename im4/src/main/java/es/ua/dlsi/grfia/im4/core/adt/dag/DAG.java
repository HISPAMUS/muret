package es.ua.dlsi.grfia.im4.core.adt.dag;

/**
 * Directed acyclic graph
 * @param <SpineItemContentType> The type of the elements that will be stored in the items
 */
public class DAG<SpineItemContentType> {
    DAGNode<SpineItemContentType> firstNode;
    DAGNode<SpineItemContentType> lastNode;

    public DAG() {
    }

    public void add(DAGItem<SpineItemContentType> item) {
        if (firstNode == null) {
            firstNode = lastNode = new DAGNode(item);
        } else {
            DAGNode<SpineItemContentType> node = new DAGNode<SpineItemContentType>(item);
            node.setPrevious(lastNode);
            lastNode.addNext(node);
        }
    }
}
