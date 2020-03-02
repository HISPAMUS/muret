package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.timesignatures;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmTimeSignature;

public class SkmTimeSignature2by4 extends SkmTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M2/4";

    public SkmTimeSignature2by4() {
        super(SKM);
    }

    @Override
    public SkmTimeSignature2by4 clone() {
        return new SkmTimeSignature2by4();
    }
}
