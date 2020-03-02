package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.headers;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmHeader;

public class SkmText extends SkmHeader {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "**text";

    public SkmText() {
        super(SKM);
    }

    @Override
    public SkmText clone() {
        return new SkmText();
    }
}
