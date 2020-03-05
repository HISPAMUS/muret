package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.accidentals;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmAccidental;

public class SkmAccidentalTripleFlat extends SkmAccidental {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "---";

    public SkmAccidentalTripleFlat() {
        super(SKM);
    }

    @Override
    public SkmAccidentalTripleFlat clone() {
        return new SkmAccidentalTripleFlat();
    }
}
