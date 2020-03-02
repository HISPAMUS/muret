package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.headers;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmHeader;

public class SkmHarmonies extends SkmHeader {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "**harm";

    public SkmHarmonies() {
        super(SKM);
    }

    @Override
    public SkmHarmonies clone() {
        return new SkmHarmonies();
    }
}
