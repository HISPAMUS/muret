package es.ua.dlsi.grfia.im4.io.skm.tokens.timesignatures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmTimeSignature;

public class SkmTimeSignature2by2 extends SkmTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M2/2";

    public SkmTimeSignature2by2() {
        super(SKM);
    }

    @Override
    public SkmTimeSignature2by2 clone() {
        return new SkmTimeSignature2by2();
    }
}
