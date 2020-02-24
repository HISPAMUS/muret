package es.ua.dlsi.grfia.im4.core.semantic.headers;

import es.ua.dlsi.grfia.im4.core.semantic.HeaderItem;

public class HeaderHarm extends HeaderItem {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "**harm";

    public HeaderHarm() {
        super(SKM);
    }
    @Override
    public HeaderHarm clone() {
        return new HeaderHarm();
    }
}
