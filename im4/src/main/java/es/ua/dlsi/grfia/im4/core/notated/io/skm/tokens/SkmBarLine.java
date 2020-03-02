package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.SkmToken;

public abstract class SkmBarLine extends SkmToken {
    /**
     * Package visibility to be used by the factory
     */
    static final String BASE_SKM = "=";

    /**
     * Optional bar number
     */
    protected final Integer barNumber;

    public SkmBarLine(String childSkmEncoding, int barNumber) {
        super(buildSkmEncoding(childSkmEncoding, barNumber));
        this.barNumber = barNumber;
    }

    private static String buildSkmEncoding(String skmEncoding, int number) {
        return BASE_SKM + number + skmEncoding;
    }

    public SkmBarLine(String childSkmEncoding) {
        super(BASE_SKM + childSkmEncoding);
        this.barNumber = null;
    }

    public Integer getBarNumber() {
        return barNumber;
    }
}
