package es.ua.dlsi.grfia.im4.io.skm.tokens.meters.mensural;

/**
 * Visually rendered as O  with a dot inside
 * 1 breve = 3 semibreves, 1 semibreve = 3 minim
 */
public class SkmTempusPerfectumCumProlationePerfecta extends SkmMensuralMeter {
    /**
     * Package visibility to be used by the factory
     */
    public static final String SKM = "*met(O.)";

    public SkmTempusPerfectumCumProlationePerfecta() {
        super(SKM);
    }

    @Override
    public SkmTempusPerfectumCumProlationePerfecta clone() {
        return new SkmTempusPerfectumCumProlationePerfecta();
    }
}
