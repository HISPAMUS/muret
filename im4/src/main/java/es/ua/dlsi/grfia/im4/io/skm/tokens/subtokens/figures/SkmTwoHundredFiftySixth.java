package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmFigure;

public class SkmTwoHundredFiftySixth extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "256";

    public SkmTwoHundredFiftySixth() {
        super(SKM);
    }

    @Override
    public SkmTwoHundredFiftySixth clone() {
        return new SkmTwoHundredFiftySixth();
    }
}
