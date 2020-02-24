package es.ua.dlsi.grfia.im4.core.semantic.timesignatures;

public class TimeSignature9by8 extends FractionalTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M9/8";

    public TimeSignature9by8() {
        super(SKM, 9, 8);
    }

    @Override
    public TimeSignature9by8 clone() {
        return new TimeSignature9by8();
    }
}
