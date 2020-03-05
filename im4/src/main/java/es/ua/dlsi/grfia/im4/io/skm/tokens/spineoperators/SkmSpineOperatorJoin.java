package es.ua.dlsi.grfia.im4.io.skm.tokens.spineoperators;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmSpineOperator;

public class SkmSpineOperatorJoin extends SkmSpineOperator {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*v";

    public SkmSpineOperatorJoin() {
        super(SKM);
    }


    @Override
    public SkmSpineOperatorJoin clone() {
        return new SkmSpineOperatorJoin();
    }
}
