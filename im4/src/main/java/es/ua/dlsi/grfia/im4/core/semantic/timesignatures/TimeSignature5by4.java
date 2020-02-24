package es.ua.dlsi.grfia.im4.core.semantic.timesignatures;

public class TimeSignature5by4 extends FractionalTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M5/4";

    public TimeSignature5by4() {
        super(SKM, 5, 4);
    }

    @Override
    public TimeSignature5by4 clone() {
        return new TimeSignature5by4();
    }
}
