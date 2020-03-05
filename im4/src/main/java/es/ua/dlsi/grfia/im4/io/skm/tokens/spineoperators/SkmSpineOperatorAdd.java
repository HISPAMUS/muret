package es.ua.dlsi.grfia.im4.io.skm.tokens.spineoperators;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmSpineOperator;

public class SkmSpineOperatorAdd extends SkmSpineOperator {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*+";

    public SkmSpineOperatorAdd() {
        super(SKM);
    }


    @Override
    public SkmSpineOperatorAdd clone() {
        return new SkmSpineOperatorAdd();
    }
}
