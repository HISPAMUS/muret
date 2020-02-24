package es.ua.dlsi.grfia.im4.core.semantic.timesignatures;

public class TimeSignature12by8 extends FractionalTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M12/8";

    public TimeSignature12by8() {
        super(SKM, 12, 8);
    }

    @Override
    public TimeSignature12by8 clone() {
        return new TimeSignature12by8();
    }
}
