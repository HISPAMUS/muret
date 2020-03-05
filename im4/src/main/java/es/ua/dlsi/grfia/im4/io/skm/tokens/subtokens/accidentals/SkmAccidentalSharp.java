package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.accidentals;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmAccidental;

public class SkmAccidentalSharp extends SkmAccidental {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "#";

    public SkmAccidentalSharp() {
        super(SKM);
    }

    @Override
    public SkmAccidentalSharp clone() {
        return new SkmAccidentalSharp();
    }
}
