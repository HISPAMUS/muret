package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.timesignatures;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmTimeSignature;

public class SkmTimeSignature3by8 extends SkmTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M3/8";

    public SkmTimeSignature3by8() {
        super(SKM);
    }

    @Override
    public SkmTimeSignature3by8 clone() {
        return new SkmTimeSignature3by8();
    }
}
