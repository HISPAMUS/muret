package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmFigure;

public class SkmBreve extends SkmFigure {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "S";

    public SkmBreve() {
        super(SKM);
    }

    @Override
    public SkmBreve clone() {
        return new SkmBreve();
    }
}
