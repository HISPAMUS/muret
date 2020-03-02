package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.accidentals;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmAccidental;

public class SkmAccidentalTripleSharp extends SkmAccidental {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "###";

    public SkmAccidentalTripleSharp() {
        super(SKM);
    }

    @Override
    public SkmAccidentalTripleSharp clone() {
        return new SkmAccidentalTripleSharp();
    }
}
