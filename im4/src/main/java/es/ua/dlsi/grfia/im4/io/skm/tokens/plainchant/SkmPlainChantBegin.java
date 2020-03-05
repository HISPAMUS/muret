package es.ua.dlsi.grfia.im4.io.skm.tokens.plainchant;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmPlainChant;

public class SkmPlainChantBegin extends SkmPlainChant {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*bpc";

    public SkmPlainChantBegin() {
        super(SKM);
    }

    @Override
    public SkmPlainChantBegin clone() {
        return new SkmPlainChantBegin();
    }
}
