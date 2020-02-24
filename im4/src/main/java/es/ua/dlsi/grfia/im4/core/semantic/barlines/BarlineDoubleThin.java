package es.ua.dlsi.grfia.im4.core.semantic.barlines;

import es.ua.dlsi.grfia.im4.core.semantic.BarLine;


public class BarlineDoubleThin extends BarLine {
    /**
     * Package visibility to be used by the factory
     */
    static final String CHILD_SKM = "||";

    public BarlineDoubleThin() {
        super(BASE_SKM + CHILD_SKM);
    }
    public BarlineDoubleThin(int barNumber) {
        super(BASE_SKM + barNumber + CHILD_SKM, barNumber);
    }

    @Override
    public BarlineDoubleThin clone() {
        return new BarlineDoubleThin();
    }

    @Override
    protected String getChildClassSkm() {
        return CHILD_SKM;
    }
}
