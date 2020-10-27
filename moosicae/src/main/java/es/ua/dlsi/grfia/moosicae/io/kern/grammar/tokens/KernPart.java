package es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernToken;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KernPart extends KernToken {
    private final int number;

    public KernPart(String encoding, int number) {
        super(encoding);
        this.number = number;
    }

    @Override
    public KernPart clone() {
        return new KernPart(getEncoding(), number);
    }

    public int getNumber() {
        return number;
    }
}
