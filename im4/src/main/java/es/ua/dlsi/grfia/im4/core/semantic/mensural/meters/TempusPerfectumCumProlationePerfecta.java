package es.ua.dlsi.grfia.im4.core.semantic.mensural.meters;

import es.ua.dlsi.grfia.im4.core.Time;

/**
 * Visually rendered as O  with a dot inside
 * 1 breve = 3 semibreves, 1 semibreve = 3 minim
 */
public class TempusPerfectumCumProlationePerfecta extends TimeSignatureMensural {
    public TempusPerfectumCumProlationePerfecta() {
        super(Perfection.imperfectum, Perfection.imperfectum, Perfection.perfectum, Perfection.perfectum);
    }

    @Override
    public Time getDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusPerfectumCumProlationePerfecta clone() {
        return new TempusPerfectumCumProlationePerfecta();
    }

    @Override
    public String getSignString() {
        return "O.";
    }

}
