package es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmToken;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmStaff extends SkmToken {
    private final int number;

    public SkmStaff(String encoding, int number) {
        super(encoding);
        this.number = number;
    }

    @Override
    public SkmStaff clone() {
        return new SkmStaff(getEncoding(), number);
    }

    public int getNumber() {
        return number;
    }
}
