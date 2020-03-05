package es.ua.dlsi.grfia.im4.io.skm.tokens.timesignatures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmTimeSignature;

public class SkmTimeSignature9by8 extends SkmTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M9/8";

    public SkmTimeSignature9by8() {
        super(SKM);
    }

    @Override
    public SkmTimeSignature9by8 clone() {
        return new SkmTimeSignature9by8();
    }
}
