package es.ua.dlsi.grfia.im4.io.skm.tokens.keys;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmKey;

public class SkmKeyCMajor extends SkmKey {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*k[]";

    public SkmKeyCMajor() {
        super(SKM);
    }

    @Override
    public SkmKeyCMajor clone() {
        return new SkmKeyCMajor();
    }
}
