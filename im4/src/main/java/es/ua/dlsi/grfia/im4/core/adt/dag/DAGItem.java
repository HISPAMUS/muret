package es.ua.dlsi.grfia.im4.core.adt.dag;

public class DAGItem<SpineItemContentType> {
    SpineItemContentType content;

    public DAGItem(SpineItemContentType content) {
        this.content = content;
    }

    @Override
    public String toString() {
        if (content == null) {
            return "";
        } else {
            return content.toString();
        }
    }
}
