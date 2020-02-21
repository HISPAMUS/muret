package es.ua.dlsi.grfia.im4.core.semantic.mensural.meters;

import es.ua.dlsi.grfia.im4.core.Time;

public class ProportioTripla extends TimeSignatureMensural {
    public ProportioTripla() {
        super(Perfection.imperfectum, Perfection.imperfectum, Perfection.perfectum, Perfection.imperfectum);
    }

    @Override
    public ProportioTripla clone() {
        return new ProportioTripla();
    }

    @Override
    public String getSignString() {
        return "3";
    }

    @Override
    public Time getDuration() {
        return getSemibreveDuration(); //TODO Comprobar
    }
}
