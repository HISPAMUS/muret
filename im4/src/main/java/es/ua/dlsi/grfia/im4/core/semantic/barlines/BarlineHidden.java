package es.ua.dlsi.grfia.im4.core.semantic.barlines;

import es.ua.dlsi.grfia.im4.core.semantic.BarLine;

public class BarlineHidden extends BarLine {
    /**
     * Package visibility to be used by the factory
     */
    static final String CHILD_SKM = "-";

    public BarlineHidden() {
        super(BASE_SKM + CHILD_SKM);
    }
    public BarlineHidden(int barNumber) {
        super(BASE_SKM + barNumber + CHILD_SKM, barNumber);
    }

    @Override
    public BarlineHidden clone() {
        return new BarlineHidden();
    }

    @Override
    protected String getChildClassSkm() {
        return CHILD_SKM;
    }

}
