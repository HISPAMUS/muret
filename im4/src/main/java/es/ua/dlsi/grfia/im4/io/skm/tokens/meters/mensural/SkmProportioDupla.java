package es.ua.dlsi.grfia.im4.io.skm.tokens.meters.mensural;

public class SkmProportioDupla extends SkmMensuralMeter {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*met(2)";

    public SkmProportioDupla() {
        super(SKM);
    }

    @Override
    public SkmProportioDupla clone() {
        return new SkmProportioDupla();
    }
}
