package es.ua.dlsi.grfia.im4.utils.visitor;

/**
 * Inherit is as concrete decorators
 */
public abstract class VisitorBaseDecorator<VisitorComponentType extends IVisitorComponent> {
    private final VisitorComponentType wrappee;

    public VisitorBaseDecorator(VisitorComponentType wrappee) {
        this.wrappee = wrappee;
    }

    public VisitorComponentType getWrappee() {
        return wrappee;
    }
}
