package es.ua.dlsi.grfia.im4.io.skm.tokens.barlines;


import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmBarLine;

public class SkmBarLineHidden extends SkmBarLine {
    /**
     * Package visibility to be used by the factory
     */
    static final String CHILD_SKM = "-";

    public SkmBarLineHidden() {
        super(CHILD_SKM);
    }
    public SkmBarLineHidden(int barNumber) {
        super(CHILD_SKM, barNumber);
    }

    @Override
    public SkmBarLineHidden clone() {
        if (barNumber == null) {
            return new SkmBarLineHidden(barNumber);
        } else {
            return new SkmBarLineHidden();
        }
    }

}
