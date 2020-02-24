package es.ua.dlsi.grfia.im4.core.semantic;

public class CompositionStartItem extends SemanticItem {
    public CompositionStartItem() {
        super("---start item---");
    }

    @Override
    public CompositionStartItem clone() {
        return new CompositionStartItem();
    }
}
