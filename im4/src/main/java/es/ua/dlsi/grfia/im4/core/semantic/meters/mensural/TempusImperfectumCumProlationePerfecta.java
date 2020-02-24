package es.ua.dlsi.grfia.im4.core.semantic.meters.mensural;


import es.ua.dlsi.grfia.im4.core.Time;
import es.ua.dlsi.grfia.im4.core.semantic.Perfection;

/**
 * Visually rendered as C with a dot inside
 * 1 breve = 2 semibreves, 1 semibreve = 3 minim
 */
public class TempusImperfectumCumProlationePerfecta extends MeterMensural {
    /**
     * Package visibility to be used by the factory
     */
    public static final String SKM = "*met(C.)";

    public TempusImperfectumCumProlationePerfecta() {
        super(SKM, Perfection.imperfectum, Perfection.imperfectum, Perfection.imperfectum, Perfection.perfectum);
    }

    @Override
    public Time getDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusImperfectumCumProlationePerfecta clone() {
        return new TempusImperfectumCumProlationePerfecta();
    }


}
