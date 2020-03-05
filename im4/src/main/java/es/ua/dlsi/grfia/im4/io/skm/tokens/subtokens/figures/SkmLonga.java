package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmFigure;

public class SkmLonga extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "L";

    public SkmLonga() {
        super(SKM);
    }

    @Override
    public SkmLonga clone() {
        return new SkmLonga();
    }
}
