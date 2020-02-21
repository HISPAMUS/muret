package es.ua.dlsi.grfia.im4.core.semantic.mensural.meters;


import es.ua.dlsi.grfia.im4.core.Time;

/**
 * Visually rendered as C with a dot inside
 * 1 breve = 2 semibreves, 1 semibreve = 3 minim
 */
public class TempusImperfectumCumProlationePerfecta extends TimeSignatureMensural {
    public TempusImperfectumCumProlationePerfecta() {
        super(Perfection.imperfectum, Perfection.imperfectum, Perfection.imperfectum, Perfection.perfectum);
    }

    @Override
    public Time getDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusImperfectumCumProlationePerfecta clone() {
        return new TempusImperfectumCumProlationePerfecta();
    }

    @Override
    public String getSignString() {
        return "C.";
    }

}
