package es.ua.dlsi.grfia.im4.core.semantic.meters;


import es.ua.dlsi.grfia.im4.core.semantic.NotationType;
import es.ua.dlsi.grfia.im4.core.semantic.TimeSignature;

/**
 * A time signature specified with just a sign. This is a convenience class for the layout factories
 */
public abstract class SignTimeSignature extends TimeSignature {
    public SignTimeSignature(NotationType notationType) {
        super(notationType);
    }

    public abstract SignTimeSignature clone();

    /**
     * A kind of toString just for the sign
     * @return
     */
    public abstract String getSignString();


}
