package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.alterationqualifiers;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmAlterationQualifier;

public class SkmAlterationFicta extends SkmAlterationQualifier {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "Y";

    public SkmAlterationFicta() {
        super(SKM);
    }

    @Override
    public SkmAlterationFicta clone() {
        return new SkmAlterationFicta();
    }
}
