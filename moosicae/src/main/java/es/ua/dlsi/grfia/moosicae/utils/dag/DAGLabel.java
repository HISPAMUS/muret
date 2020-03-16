package es.ua.dlsi.grfia.moosicae.utils.dag;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class DAGLabel<ContentType> {
    ContentType content;

    public DAGLabel(ContentType content) {
        this.content = content;
    }

    public ContentType getContent() {
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
