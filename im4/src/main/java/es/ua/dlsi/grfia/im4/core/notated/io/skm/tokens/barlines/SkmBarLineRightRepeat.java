package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.barlines;


import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmBarLine;

public class SkmBarLineRightRepeat extends SkmBarLine {
    /**
     * Package visibility to be used by the factory
     */
    static final String CHILD_SKM = ":|!";

    public SkmBarLineRightRepeat() {
        super(CHILD_SKM);
    }
    public SkmBarLineRightRepeat(int barNumber) {
        super(CHILD_SKM, barNumber);
    }

    @Override
    public SkmBarLineRightRepeat clone() {
        if (barNumber == null) {
            return new SkmBarLineRightRepeat(barNumber);
        } else {
            return new SkmBarLineRightRepeat();
        }
    }


}
