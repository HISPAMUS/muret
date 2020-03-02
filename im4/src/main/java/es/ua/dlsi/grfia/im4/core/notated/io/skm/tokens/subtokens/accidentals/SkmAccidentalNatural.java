package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.accidentals;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmAccidental;

public class SkmAccidentalNatural extends SkmAccidental {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "";

    public SkmAccidentalNatural() {
        super(SKM);
    }

    @Override
    public SkmAccidentalNatural clone() {
        return new SkmAccidentalNatural();
    }
}
