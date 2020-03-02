package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.meters.mensural;

/**
 * Visually rendered as O
 * 1 breve = 3 semibreves, 1 semibreve = 2 minim
 */
public class SkmTempusPerfectumCumProlationeImperfecta extends SkmMensuralMeter {
    /**
     * Package visibility to be used by the factory
     */
    public static final String SKM = "*met(O)";

    public SkmTempusPerfectumCumProlationeImperfecta() {
        super(SKM);
    }

    @Override
    public SkmTempusPerfectumCumProlationeImperfecta clone() {
        return new SkmTempusPerfectumCumProlationeImperfecta();
    }

}
