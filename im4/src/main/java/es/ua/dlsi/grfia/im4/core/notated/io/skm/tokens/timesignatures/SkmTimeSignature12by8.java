package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.timesignatures;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmTimeSignature;

public class SkmTimeSignature12by8 extends SkmTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M12/8";

    public SkmTimeSignature12by8() {
        super(SKM);
    }

    @Override
    public SkmTimeSignature12by8 clone() {
        return new SkmTimeSignature12by8();
    }
}
