package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmFigure;

public class SkmSixteenth extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "16";

    public SkmSixteenth() {
        super(SKM);
    }

    @Override
    public SkmSixteenth clone() {
        return new SkmSixteenth();
    }
}