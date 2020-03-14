package es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmToken;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
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
