package es.ua.dlsi.grfia.im4.core.semantic.timesignatures;

public class TimeSignature2by4 extends FractionalTimeSignature {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*M2/4";

    public TimeSignature2by4() {
        super(SKM, 2, 4);
    }

    @Override
    public TimeSignature2by4 clone() {
        return new TimeSignature2by4();
    }
}
