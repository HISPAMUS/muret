package es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernToken;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KernStaff extends KernToken {
    private final int number;

    public KernStaff(String encoding, int number) {
        super(encoding);
        this.number = number;
    }

    @Override
    public KernStaff clone() {
        return new KernStaff(getEncoding(), number);
    }

    public int getNumber() {
        return number;
    }
}
