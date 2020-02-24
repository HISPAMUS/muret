package es.ua.dlsi.grfia.im4.core.semantic.barlines;

import es.ua.dlsi.grfia.im4.core.semantic.BarLine;

public class BarlineFinal extends BarLine {
    /**
     * Package visibility to be used by the factory
     */
    static final String CHILD_SKM = "=";

    public BarlineFinal() {
        super(BASE_SKM + CHILD_SKM);
    }

    private BarlineFinal(int barNumber) {
        super(BASE_SKM + barNumber + CHILD_SKM, barNumber);
        // this bar line does not make sense because the final does not start any measure
    }

    @Override
    public BarlineFinal clone() {
        return new BarlineFinal();
    }

    @Override
    protected String getChildClassSkm() {
        return CHILD_SKM;
    }

}
