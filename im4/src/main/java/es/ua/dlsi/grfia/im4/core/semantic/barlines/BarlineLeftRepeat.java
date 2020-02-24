package es.ua.dlsi.grfia.im4.core.semantic.barlines;

import es.ua.dlsi.grfia.im4.core.semantic.BarLine;

public class BarlineLeftRepeat extends BarLine {
    /**
     * Package visibility to be used by the factory
     */
    static final String CHILD_SKM = "!|:";


    public BarlineLeftRepeat() {
        super(BASE_SKM + CHILD_SKM);
    }
    public BarlineLeftRepeat(int barNumber) {
        super(BASE_SKM + barNumber + CHILD_SKM, barNumber);
    }

    @Override
    public BarlineLeftRepeat clone() {
        return new BarlineLeftRepeat();
    }

    @Override
    protected String getChildClassSkm() {
        return CHILD_SKM;
    }

}
