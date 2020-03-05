package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmFigure;

public class SkmWhole extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "1";

    public SkmWhole() {
        super(SKM);
    }

    @Override
    public SkmWhole clone() {
        return new SkmWhole();
    }
}
