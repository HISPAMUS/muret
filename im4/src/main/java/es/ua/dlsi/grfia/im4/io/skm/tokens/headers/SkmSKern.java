package es.ua.dlsi.grfia.im4.io.skm.tokens.headers;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmHeader;

public class SkmSKern extends SkmHeader {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "**skern";

    public SkmSKern() {
        super(SKM);
    }

    @Override
    public SkmSKern clone() {
        return new SkmSKern();
    }
}
