package es.ua.dlsi.grfia.im4.core.semantic.barlines;

import es.ua.dlsi.grfia.im4.core.semantic.BarLine;

public class BarlineSingle extends BarLine {
    /**
     * Package visibility to be used by the factory
     */
    static final String CHILD_SKM = "";

    public BarlineSingle() {
        super(BASE_SKM);
    }

    public BarlineSingle(int barNumber) {
        super(BASE_SKM + barNumber, barNumber);
    }

    @Override
    public BarlineSingle clone() {
        return new BarlineSingle();
    }

    @Override
    protected String getChildClassSkm() {
        return "";
    }

}
