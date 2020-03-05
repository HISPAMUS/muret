package es.ua.dlsi.grfia.im4.io.skm.tokens.timesignatures;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmTimeSignature;

public class SkmTimeSignature5by4 extends SkmTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M5/4";

    public SkmTimeSignature5by4() {
        super(SKM);
    }

    @Override
    public SkmTimeSignature5by4 clone() {
        return new SkmTimeSignature5by4();
    }
}
