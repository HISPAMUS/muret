package es.ua.dlsi.grfia.im4.core.semantic.headers;

import es.ua.dlsi.grfia.im4.core.semantic.HeaderItem;

public class HeaderText extends HeaderItem {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "**text";

    public HeaderText() {
        super(SKM);
    }
    @Override
    public HeaderText clone() {
        return new HeaderText();
    }
}
