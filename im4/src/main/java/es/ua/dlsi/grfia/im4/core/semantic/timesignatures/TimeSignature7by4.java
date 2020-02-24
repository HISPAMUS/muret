package es.ua.dlsi.grfia.im4.core.semantic.timesignatures;

public class TimeSignature7by4 extends FractionalTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M7/4";

    public TimeSignature7by4() {
        super(SKM, 7, 4);
    }

    @Override
    public TimeSignature7by4 clone() {
        return new TimeSignature7by4();
    }
}
