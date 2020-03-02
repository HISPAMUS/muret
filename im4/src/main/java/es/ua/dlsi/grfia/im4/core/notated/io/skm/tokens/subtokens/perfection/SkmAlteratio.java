package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.perfection;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmPerfection;

public class SkmAlteratio extends SkmPerfection {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "I";

    public SkmAlteratio() {
        super(SKM);
    }

    @Override
    public SkmAlteratio clone() {
        return new SkmAlteratio();
    }
}
