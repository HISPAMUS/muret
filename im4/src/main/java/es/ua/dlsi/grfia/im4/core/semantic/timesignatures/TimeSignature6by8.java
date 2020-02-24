package es.ua.dlsi.grfia.im4.core.semantic.timesignatures;

public class TimeSignature6by8 extends FractionalTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M6/8";

    public TimeSignature6by8() {
        super(SKM, 6, 8);
    }

    @Override
    public TimeSignature6by8 clone() {
        return new TimeSignature6by8();
    }
}
