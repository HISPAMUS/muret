package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.meters.mensural;

/**
 * Visually rendered as C
 * 1 breve = 2 semibreves, 1 semibreve = 2 minim
 */
public class SkmTempusImperfectumCumProlationeImperfecta extends SkmMensuralMeter {
    /**
     * Package visibility to be used by the factory
     */
    public static final String SKM = "*met(C)";

    public SkmTempusImperfectumCumProlationeImperfecta() {
        super(SKM);
    }

    @Override
    public SkmTempusImperfectumCumProlationeImperfecta clone() {
        return new SkmTempusImperfectumCumProlationeImperfecta();
    }

}
