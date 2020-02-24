package es.ua.dlsi.grfia.im4.core.semantic.headers;

import es.ua.dlsi.grfia.im4.core.semantic.HeaderItem;

public class HeaderSKern extends HeaderItem {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "**skern";

    public HeaderSKern() {
        super(SKM);
    }
    @Override
    public HeaderSKern clone() {
        return new HeaderSKern();
    }
}
