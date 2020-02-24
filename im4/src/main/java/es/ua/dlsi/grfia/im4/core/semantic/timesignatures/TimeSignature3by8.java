package es.ua.dlsi.grfia.im4.core.semantic.timesignatures;

public class TimeSignature3by8 extends FractionalTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M3/8";

    public TimeSignature3by8() {
        super(SKM, 3, 8);
    }

    @Override
    public TimeSignature3by8 clone() {
        return new TimeSignature3by8();
    }
}
