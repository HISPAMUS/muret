package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.stems;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmStemDirection;
import es.ua.dlsi.grfia.im4.io.skm.SkmItem;

public class SkmStemDown extends SkmStemDirection {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "\\";

    public SkmStemDown() {
        super(SKM);
    }

    @Override
    public SkmItem clone() {
        return new SkmStemDown();
    }
}
