package es.ua.dlsi.grfia.im4.io.skm.tokens.timesignatures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmTimeSignature;

public class SkmTimeSignature3by4 extends SkmTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M3/4";

    public SkmTimeSignature3by4() {
        super(SKM);
    }

    @Override
    public SkmTimeSignature3by4 clone() {
        return new SkmTimeSignature3by4();
    }
}
