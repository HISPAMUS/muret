package es.ua.dlsi.grfia.im4.core.semantic.meters.mensural;


import es.ua.dlsi.grfia.im4.core.Time;
import es.ua.dlsi.grfia.im4.core.semantic.Perfection;

/**
 * Visually rendered as C
 * 1 breve = 2 semibreves, 1 semibreve = 2 minim
 */
public class TempusImperfectumCumProlationeImperfecta extends MeterMensural {
    /**
     * Package visibility to be used by the factory
     */
    public static final String SKM = "*met(C)";

    public TempusImperfectumCumProlationeImperfecta() {
        super(SKM, Perfection.imperfectum, Perfection.imperfectum, Perfection.imperfectum, Perfection.imperfectum);
    }

    @Override
    public Time getDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusImperfectumCumProlationeImperfecta clone() {
        return new TempusImperfectumCumProlationeImperfecta();
    }

}
