package es.ua.dlsi.grfia.im4.core.semantic.headers;

import es.ua.dlsi.grfia.im4.core.semantic.HeaderItem;

public class HeaderDynamics extends HeaderItem {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "**dyn";

    public HeaderDynamics() {
        super(SKM);
    }
    @Override
    public HeaderDynamics clone() {
        return new HeaderDynamics();
    }
}
