package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.alterationqualifiers;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmAlterationQualifier;

public class SkmAlterationCautionary extends SkmAlterationQualifier {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "yy";

    public SkmAlterationCautionary() {
        super(SKM);
    }

    @Override
    public SkmAlterationCautionary clone() {
        return new SkmAlterationCautionary();
    }
}
