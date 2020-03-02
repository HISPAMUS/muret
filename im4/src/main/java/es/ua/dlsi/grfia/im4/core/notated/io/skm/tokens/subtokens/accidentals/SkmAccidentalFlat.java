package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.accidentals;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmAccidental;

public class SkmAccidentalFlat extends SkmAccidental {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "-";

    public SkmAccidentalFlat() {
        super(SKM);
    }

    @Override
    public SkmAccidentalFlat clone() {
        return new SkmAccidentalFlat();
    }
}
