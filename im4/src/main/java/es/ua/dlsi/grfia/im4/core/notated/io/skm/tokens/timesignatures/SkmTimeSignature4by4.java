package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.timesignatures;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmTimeSignature;

public class SkmTimeSignature4by4 extends SkmTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M3/4";

    public SkmTimeSignature4by4() {
        super(SKM);
    }

    @Override
    public SkmTimeSignature4by4 clone() {
        return new SkmTimeSignature4by4();
    }
}
