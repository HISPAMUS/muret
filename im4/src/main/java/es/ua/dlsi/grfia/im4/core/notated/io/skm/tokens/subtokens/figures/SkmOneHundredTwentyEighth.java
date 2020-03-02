package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmFigure;

public class SkmOneHundredTwentyEighth extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "128";

    public SkmOneHundredTwentyEighth() {
        super(SKM);
    }

    @Override
    public SkmOneHundredTwentyEighth clone() {
        return new SkmOneHundredTwentyEighth();
    }
}
