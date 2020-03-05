package es.ua.dlsi.grfia.im4.io.skm.tokens.headers;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmHeader;

public class SkmDynamics extends SkmHeader {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "**dyn";

    public SkmDynamics() {
        super(SKM);
    }

    @Override
    public SkmDynamics clone() {
        return new SkmDynamics();
    }
}
