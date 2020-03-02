package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.headers;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmHeader;

public class SkmSMens extends SkmHeader {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "**smens";

    public SkmSMens() {
        super(SKM);
    }

    @Override
    public SkmSMens clone() {
        return new SkmSMens();
    }
}
