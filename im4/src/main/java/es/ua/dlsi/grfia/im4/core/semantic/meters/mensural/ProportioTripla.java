package es.ua.dlsi.grfia.im4.core.semantic.meters.mensural;

import es.ua.dlsi.grfia.im4.core.Time;
import es.ua.dlsi.grfia.im4.core.semantic.Perfection;

public class ProportioTripla extends MeterMensural {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*met(3)";

    public ProportioTripla() {
        super(SKM, Perfection.imperfectum, Perfection.imperfectum, Perfection.perfectum, Perfection.imperfectum);
    }

    @Override
    public ProportioTripla clone() {
        return new ProportioTripla();
    }

    @Override
    public Time getDuration() {
        return getSemibreveDuration(); //TODO Comprobar
    }
}
