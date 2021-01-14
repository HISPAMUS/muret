package es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernToken;

/**
 * Used as part name
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KernInstrument extends KernToken {
    private final String name;

    public KernInstrument(String encoding, String name) {
        super(encoding);
        this.name = name;
    }

    @Override
    public KernInstrument clone() {
        return new KernInstrument(getEncoding(), name);
    }

    public String getName() {
        return name;
    }
}
