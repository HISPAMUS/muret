package es.ua.dlsi.grfia.im4.core.semantic.mensural.meters;

//TODO Duraciones

import es.ua.dlsi.grfia.im4.core.Time;

/**
 * Visually rendered as cut time (see https://en.wikipedia.org/wiki/Mensural_notation, unicode U+1D1CD)
 * 1 breve = 2 semibreves, 1 semibreve = 2 minim
 */
public class TempusImperfectumCumProlationeImperfectaDiminutum extends TimeSignatureMensural {
    public TempusImperfectumCumProlationeImperfectaDiminutum() {
        super(Perfection.imperfectum, Perfection.imperfectum, Perfection.imperfectum, Perfection.imperfectum);
    }

    @Override
    public Time getDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusImperfectumCumProlationeImperfectaDiminutum clone() {
        return new TempusImperfectumCumProlationeImperfectaDiminutum();
    }

    @Override
    public String getSignString() {
        return "C|";
    }


}
