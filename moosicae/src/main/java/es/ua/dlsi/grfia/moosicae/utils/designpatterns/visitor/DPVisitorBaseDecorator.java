package es.ua.dlsi.grfia.moosicae.utils.designpatterns.visitor;

/**
 * Inherit is as concrete decorators
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class DPVisitorBaseDecorator<VisitorComponentType extends IDPVisitorComponent> {
    private final VisitorComponentType wrappee;

    public DPVisitorBaseDecorator(VisitorComponentType wrappee) {
        this.wrappee = wrappee;
    }

    public VisitorComponentType getWrappee() {
        return wrappee;
    }
}
