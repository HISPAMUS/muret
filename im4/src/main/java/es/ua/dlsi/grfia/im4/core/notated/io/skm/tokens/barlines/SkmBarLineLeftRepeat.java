package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.barlines;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmBarLine;

public class SkmBarLineLeftRepeat extends SkmBarLine {
    /**
     * Package visibility to be used by the factory
     */
    static final String CHILD_SKM = "!|:";


    public SkmBarLineLeftRepeat() {
        super(CHILD_SKM);
    }
    public SkmBarLineLeftRepeat(int barNumber) {
        super(CHILD_SKM, barNumber);
    }

    @Override
    public SkmBarLineLeftRepeat clone() {
        if (barNumber == null) {
            return new SkmBarLineLeftRepeat(barNumber);
        } else {
            return new SkmBarLineLeftRepeat();
        }
    }

}
