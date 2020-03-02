package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.stems;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.SkmItem;
import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmStemDirection;

public class SkmStemUp extends SkmStemDirection {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "/";

    public SkmStemUp() {
        super(SKM);
    }

    @Override
    public SkmItem clone() {
        return new SkmStemUp();
    }
}
