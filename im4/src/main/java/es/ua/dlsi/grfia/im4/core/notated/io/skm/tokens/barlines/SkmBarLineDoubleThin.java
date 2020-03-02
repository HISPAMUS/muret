package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.barlines;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmBarLine;

public class SkmBarLineDoubleThin extends SkmBarLine {
    /**
     * Package visibility to be used by the factory
     */
    static final String CHILD_SKM = "||";

    public SkmBarLineDoubleThin() {
        super(CHILD_SKM);
    }
    public SkmBarLineDoubleThin(int barNumber) {
        super(CHILD_SKM, barNumber);
    }

    @Override
    public SkmBarLineDoubleThin clone() {
        if (barNumber == null) {
            return new SkmBarLineDoubleThin(barNumber);
        } else {
            return new SkmBarLineDoubleThin();
        }
    }

}
