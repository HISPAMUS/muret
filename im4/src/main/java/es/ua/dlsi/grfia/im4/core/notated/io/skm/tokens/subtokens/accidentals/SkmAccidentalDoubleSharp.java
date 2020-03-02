package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.accidentals;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmAccidental;

public class SkmAccidentalDoubleSharp extends SkmAccidental {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "##";

    public SkmAccidentalDoubleSharp() {
        super(SKM);
    }

    @Override
    public SkmAccidentalDoubleSharp clone() {
        return new SkmAccidentalDoubleSharp();
    }
}
