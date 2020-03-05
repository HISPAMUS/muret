package es.ua.dlsi.grfia.im4.io.skm.tokens.timesignatures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmTimeSignature;

public class SkmTimeSignature6by4 extends SkmTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M6/4";

    public SkmTimeSignature6by4() {
        super(SKM);
    }

    @Override
    public SkmTimeSignature6by4 clone() {
        return new SkmTimeSignature6by4();
    }
}
