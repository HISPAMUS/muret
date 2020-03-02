package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.meters.mensural;

public class SkmProportioTripla extends SkmMensuralMeter {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*met(3)";

    public SkmProportioTripla() {
        super(SKM);
    }

    @Override
    public SkmProportioTripla clone() {
        return new SkmProportioTripla();
    }

}
