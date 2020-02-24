package es.ua.dlsi.grfia.im4.core.semantic.meters.mensural;

import es.ua.dlsi.grfia.im4.core.Time;
import es.ua.dlsi.grfia.im4.core.semantic.Perfection;

/**
 * Visually rendered as O
 * 1 breve = 3 semibreves, 1 semibreve = 2 minim
 */
public class TempusPerfectumCumProlationeImperfecta extends MeterMensural {
    /**
     * Package visibility to be used by the factory
     */
    public static final String SKM = "*met(O)";

    public TempusPerfectumCumProlationeImperfecta() {
        super(SKM, Perfection.imperfectum, Perfection.imperfectum, Perfection.perfectum, Perfection.imperfectum);
    }

    @Override
    public Time getDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusPerfectumCumProlationeImperfecta clone() {
        return new TempusPerfectumCumProlationeImperfecta();
    }

}
