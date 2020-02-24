package es.ua.dlsi.grfia.im4.core.semantic.barlines;

import es.ua.dlsi.grfia.im4.core.semantic.BarLine;
import es.ua.dlsi.grfia.im4.core.semantic.SemanticItem;

public class BarlineRightRepeat extends BarLine {
    /**
     * Package visibility to be used by the factory
     */
    static final String CHILD_SKM = ":|!";

    public BarlineRightRepeat() {
        super(BASE_SKM + CHILD_SKM);
    }
    public BarlineRightRepeat(int barNumber) {
        super(BASE_SKM + barNumber + CHILD_SKM, barNumber);
    }

    @Override
    public SemanticItem clone() {
        return new BarlineRightRepeat();
    }

    @Override
    protected String getChildClassSkm() {
        return CHILD_SKM;
    }

}
