package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.spineoperators;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmSpineOperator;

public class SkmSpineOperatorSplit extends SkmSpineOperator {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*^";

    public SkmSpineOperatorSplit() {
        super(SKM);
    }


    @Override
    public SkmSpineOperatorSplit clone() {
        return new SkmSpineOperatorSplit();
    }
}
