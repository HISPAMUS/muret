package es.ua.dlsi.grfia.im4.core.semantic.timesignatures;

public class TimeSignature6by4 extends FractionalTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M6/4";

    public TimeSignature6by4() {
        super(SKM, 6, 4);
    }

    @Override
    public TimeSignature6by4 clone() {
        return new TimeSignature6by4();
    }
}
