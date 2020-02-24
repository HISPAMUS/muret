package es.ua.dlsi.grfia.im4.core.semantic.timesignatures;

public class TimeSignature9by4 extends FractionalTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M9/4";

    public TimeSignature9by4() {
        super(SKM, 9, 4);
    }

    @Override
    public TimeSignature9by4 clone() {
        return new TimeSignature9by4();
    }
}
