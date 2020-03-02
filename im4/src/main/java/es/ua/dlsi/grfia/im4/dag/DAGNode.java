package es.ua.dlsi.grfia.im4.dag;

import java.util.LinkedList;
import java.util.List;

public class DAGNode<DAGLabelType> {
    private static long NEXT_ID = 1;
    private long uniqueID;
    private final DAGLabel<DAGLabelType> item;
    private final List<DAGNode<DAGLabelType>> nextList;
    private DAGNode<DAGLabelType> previous;

    public DAGNode(DAGLabel<DAGLabelType> item) {
        synchronized (DAGNode.class) {
            uniqueID = NEXT_ID++;
        }
        this.item = item;
        this.nextList = new LinkedList<DAGNode<DAGLabelType>>();
    }

    public long getUniqueID() {
        return uniqueID;
    }

    public DAGLabel<DAGLabelType> getItem() {
        return item;
    }

    public DAGNode<DAGLabelType> getPrevious() {
        return previous;
    }

    public void setPrevious(DAGNode<DAGLabelType> previous) {
        this.previous = previous;
    }

    public void addNext(DAGNode<DAGLabelType> next) {
        this.nextList.add(next);
    }

    public void removeNext(DAGNode<DAGLabelType> next) {
        this.nextList.remove(next);
    }

    public List<DAGNode<DAGLabelType>> getNextList() {
        return nextList;
    }
}
