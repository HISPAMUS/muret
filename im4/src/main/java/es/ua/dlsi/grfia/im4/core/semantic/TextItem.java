package es.ua.dlsi.grfia.im4.core.semantic;

public class TextItem extends SemanticItem {
    final String text;

    public TextItem(String text) {
        super(text); // it is encoded as it is written
        this.text = text;
    }

    @Override
    public TextItem clone() {
        return new TextItem(text);
    }

    public String getText() {
        return text;
    }

}
