package es.ua.dlsi.grfia.im4.io.skm.tokens.keys;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmKey;

public class SkmKeyFMajor extends SkmKey {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*k[b-]";
    public SkmKeyFMajor() {
        super(SKM);
    }

    @Override
    public SkmKeyFMajor clone() {
        return new SkmKeyFMajor();
    }
}
