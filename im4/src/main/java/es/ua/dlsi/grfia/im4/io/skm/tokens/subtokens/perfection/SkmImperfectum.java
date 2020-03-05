package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.perfection;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmPerfection;

public class SkmImperfectum extends SkmPerfection {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "i";

    public SkmImperfectum() {
        super(SKM);
    }

    @Override
    public SkmImperfectum clone() {
        return new SkmImperfectum();
    }
}
