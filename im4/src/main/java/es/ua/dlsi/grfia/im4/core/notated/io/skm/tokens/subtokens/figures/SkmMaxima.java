package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmFigure;

public class SkmMaxima extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "X";

    public SkmMaxima() {
        super(SKM);
    }

    @Override
    public SkmMaxima clone() {
        return new SkmMaxima();
    }
}
