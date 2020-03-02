package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmFigure;

public class SkmFusa extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "U";

    public SkmFusa() {
        super(SKM);
    }

    @Override
    public SkmFusa clone() {
        return new SkmFusa();
    }
}
