package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.SkmToken;

public class SkmStaff extends SkmToken {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*I";

    private final int number;

    public SkmStaff(int number) {
        super(SKM + number);
        this.number = number;
    }

    @Override
    public SkmStaff clone() {
        return new SkmStaff(number);
    }

    public int getNumber() {
        return number;
    }
}
