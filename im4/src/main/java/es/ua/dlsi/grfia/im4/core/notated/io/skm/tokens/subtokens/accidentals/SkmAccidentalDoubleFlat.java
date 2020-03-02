package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.accidentals;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmAccidental;

public class SkmAccidentalDoubleFlat extends SkmAccidental {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "--";

    public SkmAccidentalDoubleFlat() {
        super(SKM);
    }

    @Override
    public SkmAccidentalDoubleFlat clone() {
        return new SkmAccidentalDoubleFlat();
    }
}
