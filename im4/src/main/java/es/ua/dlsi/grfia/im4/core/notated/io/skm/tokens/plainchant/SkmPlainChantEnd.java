package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.plainchant;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmPlainChant;

public class SkmPlainChantEnd extends SkmPlainChant {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*epc";

    public SkmPlainChantEnd() {
        super(SKM);
    }

    @Override
    public SkmPlainChantEnd clone() {
        return new SkmPlainChantEnd();
    }
}
