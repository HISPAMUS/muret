package es.ua.dlsi.grfia.im4.core.semantic.barlines;

import es.ua.dlsi.grfia.im4.core.semantic.BarLine;

public class BarlineLeftRightRepeat extends BarLine {
    /**
     * Package visibility to be used by the factory
     */
    static final String CHILD_SKM = ":|!|:";

    public BarlineLeftRightRepeat() {
        super(BASE_SKM + CHILD_SKM);
    }
    public BarlineLeftRightRepeat(int barNumber) {
        super(BASE_SKM + barNumber + CHILD_SKM, barNumber);
    }

    @Override
    public BarlineLeftRightRepeat clone() {
        return new BarlineLeftRightRepeat();
    }

    @Override
    protected String getChildClassSkm() {
        return CHILD_SKM;
    }

}
