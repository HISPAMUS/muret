package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmFigure;

public class SkmHalf extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "2";

    public SkmHalf() {
        super(SKM);
    }

    @Override
    public SkmHalf clone() {
        return new SkmHalf();
    }
}
