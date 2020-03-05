package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmFigure;

public class SkmMinima extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "M";

    public SkmMinima() {
        super(SKM);
    }

    @Override
    public SkmMinima clone() {
        return new SkmMinima();
    }
}
