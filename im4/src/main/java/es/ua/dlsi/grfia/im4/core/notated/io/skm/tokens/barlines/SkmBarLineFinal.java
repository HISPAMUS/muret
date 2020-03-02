package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.barlines;


import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmBarLine;

public class SkmBarLineFinal extends SkmBarLine {
    /**
     * Package visibility to be used by the factory
     */
    static final String CHILD_SKM = "=";

    public SkmBarLineFinal() {
        super(CHILD_SKM);
    }

    public SkmBarLineFinal(int barNumber) {
        super(CHILD_SKM, barNumber);
        // this bar line does not make sense because the final does not start any measure
    }

    @Override
    public SkmBarLineFinal clone() {
        if (barNumber == null) {
            return new SkmBarLineFinal(barNumber);
        } else {
            return new SkmBarLineFinal();
        }

    }


}
