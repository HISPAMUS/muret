package es.ua.dlsi.grfia.im4.core.semantic.mensural.meters;

import es.ua.dlsi.grfia.im4.core.Time;

public class ProportioDupla extends TimeSignatureMensural {
    public ProportioDupla() {
        super(Perfection.imperfectum, Perfection.imperfectum, Perfection.imperfectum, Perfection.imperfectum);
    }

    @Override
    public ProportioDupla clone() {
        return new ProportioDupla();
    }

    @Override
    public String getSignString() {
        return "2";
    }

    @Override
    public Time getDuration() {
        return getSemibreveDuration(); //TODO Comprobar
    }
}
