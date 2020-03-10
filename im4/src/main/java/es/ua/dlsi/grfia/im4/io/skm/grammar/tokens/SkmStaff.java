package es.ua.dlsi.grfia.im4.io.skm.grammar.tokens;

import es.ua.dlsi.grfia.im4.io.skm.SkmToken;

public class SkmStaff extends SkmToken {
    static final String SKM = "*staff";

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
