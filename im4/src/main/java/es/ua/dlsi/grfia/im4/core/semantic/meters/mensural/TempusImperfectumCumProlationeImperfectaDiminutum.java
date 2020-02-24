package es.ua.dlsi.grfia.im4.core.semantic.meters.mensural;

//TODO Duraciones

import es.ua.dlsi.grfia.im4.core.Time;
import es.ua.dlsi.grfia.im4.core.semantic.Perfection;

/**
 * Visually rendered as cut time (see https://en.wikipedia.org/wiki/Mensural_notation, unicode U+1D1CD)
 * 1 breve = 2 semibreves, 1 semibreve = 2 minim
 */
public class TempusImperfectumCumProlationeImperfectaDiminutum extends MeterMensural {
    /**
     * Package visibility to be used by the factory
     */
    public static final String SKM = "*met(C|)";

    public TempusImperfectumCumProlationeImperfectaDiminutum() {
        super(SKM, Perfection.imperfectum, Perfection.imperfectum, Perfection.imperfectum, Perfection.imperfectum);
    }

    @Override
    public Time getDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusImperfectumCumProlationeImperfectaDiminutum clone() {
        return new TempusImperfectumCumProlationeImperfectaDiminutum();
    }

}
