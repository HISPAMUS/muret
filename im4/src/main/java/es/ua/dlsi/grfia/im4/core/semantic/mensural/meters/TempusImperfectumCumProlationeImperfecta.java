package es.ua.dlsi.grfia.im4.core.semantic.mensural.meters;


import es.ua.dlsi.grfia.im4.core.Time;

/**
 * Visually rendered as C
 * 1 breve = 2 semibreves, 1 semibreve = 2 minim
 */
public class TempusImperfectumCumProlationeImperfecta extends TimeSignatureMensural {
    public TempusImperfectumCumProlationeImperfecta() {
        super(Perfection.imperfectum, Perfection.imperfectum, Perfection.imperfectum, Perfection.imperfectum);
    }

    @Override
    public Time getDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusImperfectumCumProlationeImperfecta clone() {
        return new TempusImperfectumCumProlationeImperfecta();
    }

    @Override
    public String getSignString() {
        return "C";
    }


}
