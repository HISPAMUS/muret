package es.ua.dlsi.grfia.im4.core.adt.dag;

import java.util.LinkedList;
import java.util.List;

public class DAGNode<SpineItemContentType> {
    private final DAGItem<SpineItemContentType> item;
    private final List<DAGNode<SpineItemContentType>> nextList;
    private DAGNode<SpineItemContentType> previous;

    public DAGNode(DAGItem<SpineItemContentType> item) {
        this.item = item;
        this.nextList = new LinkedList<DAGNode<SpineItemContentType>>();
    }

    public DAGItem<SpineItemContentType> getItem() {
        return item;
    }

    public DAGNode<SpineItemContentType> getPrevious() {
        return previous;
    }

    public void setPrevious(DAGNode<SpineItemContentType> previous) {
        this.previous = previous;
    }

    public void addNext(DAGNode<SpineItemContentType> next) {
        this.nextList.add(next);
    }

    public void removeNext(DAGNode<SpineItemContentType> next) {
        this.nextList.remove(next);
    }

}
