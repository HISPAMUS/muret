package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmFigure;

public class SkmEighth extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "8";

    public SkmEighth() {
        super(SKM);
    }

    @Override
    public SkmEighth clone() {
        return new SkmEighth();
    }
}
