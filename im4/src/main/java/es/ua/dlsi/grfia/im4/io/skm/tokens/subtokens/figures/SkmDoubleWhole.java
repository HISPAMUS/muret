package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmFigure;

public class SkmDoubleWhole extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "0";

    public SkmDoubleWhole() {
        super(SKM);
    }

    @Override
    public SkmDoubleWhole clone() {
        return new SkmDoubleWhole();
    }
}
