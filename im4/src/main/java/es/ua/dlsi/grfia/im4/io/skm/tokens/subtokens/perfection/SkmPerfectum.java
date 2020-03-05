package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.perfection;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmPerfection;

public class SkmPerfectum extends SkmPerfection {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "p";

    public SkmPerfectum() {
        super(SKM);
    }

    @Override
    public SkmPerfectum clone() {
        return new SkmPerfectum();
    }
}
