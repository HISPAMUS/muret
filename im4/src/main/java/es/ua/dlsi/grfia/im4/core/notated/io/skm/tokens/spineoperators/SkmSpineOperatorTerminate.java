package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.spineoperators;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmSpineOperator;

public class SkmSpineOperatorTerminate extends SkmSpineOperator {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*-";

    public SkmSpineOperatorTerminate() {
        super(SKM);
    }


    @Override
    public SkmSpineOperatorTerminate clone() {
        return new SkmSpineOperatorTerminate();
    }
}
