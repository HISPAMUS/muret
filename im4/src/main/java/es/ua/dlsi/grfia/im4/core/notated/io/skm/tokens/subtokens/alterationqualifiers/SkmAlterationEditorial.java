package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.alterationqualifiers;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmAlterationQualifier;

public class SkmAlterationEditorial extends SkmAlterationQualifier {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "YY";

    public SkmAlterationEditorial() {
        super(SKM);
    }

    @Override
    public SkmAlterationEditorial clone() {
        return new SkmAlterationEditorial();
    }
}
