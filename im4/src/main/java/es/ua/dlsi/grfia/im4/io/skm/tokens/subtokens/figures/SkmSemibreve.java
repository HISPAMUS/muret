package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmFigure;

public class SkmSemibreve extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "s";

    public SkmSemibreve() {
        super(SKM);
    }

    @Override
    public SkmSemibreve clone() {
        return new SkmSemibreve();
    }
}
