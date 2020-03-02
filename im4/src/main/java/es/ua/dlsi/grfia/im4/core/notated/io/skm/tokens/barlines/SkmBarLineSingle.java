package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.barlines;


import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmBarLine;

public class SkmBarLineSingle extends SkmBarLine {
    /**
     * Package visibility to be used by the factory
     */
    static final String CHILD_SKM = "";

    public SkmBarLineSingle() {
        super(CHILD_SKM);
    }

    public SkmBarLineSingle(int barNumber) {
        super(CHILD_SKM, barNumber);
    }

    @Override
    public SkmBarLineSingle clone() {
        if (barNumber == null) {
            return new SkmBarLineSingle(barNumber);
        } else {
            return new SkmBarLineSingle();
        }
    }
}
