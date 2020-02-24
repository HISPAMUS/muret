package es.ua.dlsi.grfia.im4.core.semantic.timesignatures;

public class TimeSignature3by4 extends FractionalTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M3/4";

    public TimeSignature3by4() {
        super(SKM, 2, 4);
    }

    @Override
    public TimeSignature3by4 clone() {
        return new TimeSignature3by4();
    }
}
