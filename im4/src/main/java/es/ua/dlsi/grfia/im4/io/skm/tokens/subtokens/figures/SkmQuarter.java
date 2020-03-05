package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmFigure;

public class SkmQuarter extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "4";

    public SkmQuarter() {
        super(SKM);
    }

    @Override
    public SkmQuarter clone() {
        return new SkmQuarter();
    }
}
