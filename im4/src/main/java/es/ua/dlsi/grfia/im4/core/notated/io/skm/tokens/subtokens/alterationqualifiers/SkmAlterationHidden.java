package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.alterationqualifiers;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmAlterationQualifier;

public class SkmAlterationHidden extends SkmAlterationQualifier {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "y";

    public SkmAlterationHidden() {
        super(SKM);
    }

    @Override
    public SkmAlterationHidden clone() {
        return new SkmAlterationHidden();
    }
}
