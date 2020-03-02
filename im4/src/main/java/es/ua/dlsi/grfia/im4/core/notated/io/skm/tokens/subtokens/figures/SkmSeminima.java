package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmFigure;

public class SkmSeminima extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "m";

    public SkmSeminima() {
        super(SKM);
    }

    @Override
    public SkmSeminima clone() {
        return new SkmSeminima();
    }
}
