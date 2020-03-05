package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmFigure;

public class SkmSixtyFourth extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "64";

    public SkmSixtyFourth() {
        super(SKM);
    }

    @Override
    public SkmSixtyFourth clone() {
        return new SkmSixtyFourth();
    }
}
