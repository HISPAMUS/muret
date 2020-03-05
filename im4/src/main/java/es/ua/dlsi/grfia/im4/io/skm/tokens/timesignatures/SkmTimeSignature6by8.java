package es.ua.dlsi.grfia.im4.io.skm.tokens.timesignatures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmTimeSignature;

public class SkmTimeSignature6by8 extends SkmTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M6/8";

    public SkmTimeSignature6by8() {
        super(SKM);
    }

    @Override
    public SkmTimeSignature6by8 clone() {
        return new SkmTimeSignature6by8();
    }
}
