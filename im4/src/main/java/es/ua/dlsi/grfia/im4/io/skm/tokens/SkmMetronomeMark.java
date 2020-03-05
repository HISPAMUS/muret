package es.ua.dlsi.grfia.im4.io.skm.tokens;

import es.ua.dlsi.grfia.im4.io.skm.SkmToken;

public class SkmMetronomeMark extends SkmToken {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*mm";

    private final int number;

    public SkmMetronomeMark(int number) {
        super(SKM + number);
        this.number = number;
    }

    @Override
    public SkmMetronomeMark clone() {
        return new SkmMetronomeMark(number);
    }

    public int getNumber() {
        return number;
    }
}
