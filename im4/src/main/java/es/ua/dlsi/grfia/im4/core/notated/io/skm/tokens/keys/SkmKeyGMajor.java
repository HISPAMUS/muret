package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.keys;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmKey;

public class SkmKeyGMajor extends SkmKey {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*k[f#]";

    public SkmKeyGMajor() {
        super(SKM);
    }

    @Override
    public SkmKeyGMajor clone() {
        return new SkmKeyGMajor();
    }
}
