package es.ua.dlsi.grfia.im4.utils.dag;

public class DAGLabel<SpineItemContentType> {
    SpineItemContentType content;

    public DAGLabel(SpineItemContentType content) {
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
