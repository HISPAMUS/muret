package es.ua.dlsi.grfia.im4.core.semantic.mensural.meters;

import es.ua.dlsi.grfia.im4.core.Time;

/**
 * Visually rendered as O
 * 1 breve = 3 semibreves, 1 semibreve = 2 minim
 */
public class TempusPerfectumCumProlationeImperfecta extends TimeSignatureMensural {
    public TempusPerfectumCumProlationeImperfecta() {
        super(Perfection.imperfectum, Perfection.imperfectum, Perfection.perfectum, Perfection.imperfectum);
    }

    @Override
    public Time getDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusPerfectumCumProlationeImperfecta clone() {
        return new TempusPerfectumCumProlationeImperfecta();
    }

    @Override
    public String getSignString() {
        return "O";
    }

}
