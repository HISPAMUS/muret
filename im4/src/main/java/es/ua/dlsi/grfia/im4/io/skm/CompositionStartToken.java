package es.ua.dlsi.grfia.im4.io.skm;

public class CompositionStartToken extends SkmToken {
    public CompositionStartToken() {
        super("---start item---");
    }

    @Override
    public CompositionStartToken clone() {
        return new CompositionStartToken();
    }
}
