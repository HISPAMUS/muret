package es.ua.dlsi.grfia.moosicae.utils.dag;

public class DAGLabel<SpineItemContentType> {
    SpineItemContentType content;

    public DAGLabel(SpineItemContentType content) {
        this.content = content;
    }

    public SpineItemContentType getContent() {
        return content;
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
