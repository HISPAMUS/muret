package es.ua.dlsi.grfia.im4.core.semantic;

/**
 * Mensural division dot. Augmentation dots are encoded along with the note or rest
 */
public class DivisionDot extends SemanticItem {
    public DivisionDot() {
        super(":");
    }

    @Override
    public DivisionDot clone() {
        return new DivisionDot();
    }
}
