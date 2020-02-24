package es.ua.dlsi.grfia.im4.core.semantic.meters.mensural;

import es.ua.dlsi.grfia.im4.core.Time;
import es.ua.dlsi.grfia.im4.core.semantic.Perfection;

public class ProportioDupla extends MeterMensural {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*met(2)";

    public ProportioDupla() {
        super(SKM, Perfection.imperfectum, Perfection.imperfectum, Perfection.imperfectum, Perfection.imperfectum);
    }

    @Override
    public ProportioDupla clone() {
        return new ProportioDupla();
    }

    @Override
    public Time getDuration() {
        return getSemibreveDuration(); //TODO Comprobar
    }
}
