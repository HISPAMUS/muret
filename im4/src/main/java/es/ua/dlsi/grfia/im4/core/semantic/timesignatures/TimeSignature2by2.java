package es.ua.dlsi.grfia.im4.core.semantic.timesignatures;

public class TimeSignature2by2 extends FractionalTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M2/2";

    public TimeSignature2by2() {
        super(SKM, 2, 2);
    }

    @Override
    public TimeSignature2by2 clone() {
        return new TimeSignature2by2();
    }
}
