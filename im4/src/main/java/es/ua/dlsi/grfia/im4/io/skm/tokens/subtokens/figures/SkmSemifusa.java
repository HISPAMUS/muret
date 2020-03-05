package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmFigure;

public class SkmSemifusa extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "u";

    public SkmSemifusa() {
        super(SKM);
    }

    @Override
    public SkmSemifusa clone() {
        return new SkmSemifusa();
    }
}
