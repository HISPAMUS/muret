package es.ua.dlsi.grfia.im4.core.semantic.meters;


import es.ua.dlsi.grfia.im4.core.semantic.NotationType;
import es.ua.dlsi.grfia.im4.core.semantic.TimeSignature;

/**
 * A time signature specified with just a sign. This is a convenience class for the layout factories
 */
public abstract class Meter extends TimeSignature {
    public Meter(String skmEncoding) {
        super(skmEncoding);
    }
}
