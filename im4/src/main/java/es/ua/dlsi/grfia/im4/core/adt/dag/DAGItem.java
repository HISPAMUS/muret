package es.ua.dlsi.grfia.im4.core.adt.dag;

public class DAGItem<SpineItemContentType> {
    SpineItemContentType content;

    public DAGItem(SpineItemContentType content) {
        this.content = content;
    }
}
