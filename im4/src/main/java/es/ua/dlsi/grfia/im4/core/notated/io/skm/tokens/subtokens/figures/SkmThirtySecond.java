package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmFigure;

public class SkmThirtySecond extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "32";

    public SkmThirtySecond() {
        super(SKM);
    }

    @Override
    public SkmThirtySecond clone() {
        return new SkmThirtySecond();
    }
}
