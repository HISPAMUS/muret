package es.ua.dlsi.grfia.im4.core.semantic.timesignatures;

public class TimeSignature4by4 extends FractionalTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M3/4";

    public TimeSignature4by4() {
        super(SKM, 4, 4);
    }

    @Override
    public TimeSignature4by4 clone() {
        return new TimeSignature4by4();
    }
}
