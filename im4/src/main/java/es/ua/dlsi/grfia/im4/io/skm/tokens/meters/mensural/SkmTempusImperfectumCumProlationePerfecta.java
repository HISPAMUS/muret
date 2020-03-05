package es.ua.dlsi.grfia.im4.io.skm.tokens.meters.mensural;


/**
 * Visually rendered as C with a dot inside
 * 1 breve = 2 semibreves, 1 semibreve = 3 minim
 */
public class SkmTempusImperfectumCumProlationePerfecta extends SkmMensuralMeter {
    /**
     * Package visibility to be used by the factory
     */
    public static final String SKM = "*met(C.)";

    public SkmTempusImperfectumCumProlationePerfecta() {
        super(SKM);
    }

    @Override
    public SkmTempusImperfectumCumProlationePerfecta clone() {
        return new SkmTempusImperfectumCumProlationePerfecta();
    }


}
