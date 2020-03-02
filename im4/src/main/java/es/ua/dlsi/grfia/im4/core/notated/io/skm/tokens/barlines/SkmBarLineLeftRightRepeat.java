package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.barlines;


import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmBarLine;

public class SkmBarLineLeftRightRepeat extends SkmBarLine {
    /**
     * Package visibility to be used by the factory
     */
    static final String CHILD_SKM = ":|!|:";

    public SkmBarLineLeftRightRepeat() {
        super(CHILD_SKM);
    }
    public SkmBarLineLeftRightRepeat(int barNumber) {
        super(CHILD_SKM, barNumber);
    }

    @Override
    public SkmBarLineLeftRightRepeat clone() {
        if (barNumber == null) {
            return new SkmBarLineLeftRightRepeat(barNumber);
        } else {
            return new SkmBarLineLeftRightRepeat();
        }
    }

}
