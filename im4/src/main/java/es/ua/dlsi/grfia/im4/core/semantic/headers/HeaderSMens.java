package es.ua.dlsi.grfia.im4.core.semantic.headers;

import es.ua.dlsi.grfia.im4.core.semantic.HeaderItem;

public class HeaderSMens extends HeaderItem {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "**smens";

    public HeaderSMens() {
        super(SKM);
    }
    @Override
    public HeaderSMens clone() {
        return new HeaderSMens();
    }
}
