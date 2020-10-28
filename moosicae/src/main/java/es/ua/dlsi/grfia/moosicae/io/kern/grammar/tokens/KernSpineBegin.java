package es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernToken;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 28/10/2020
 */
public class KernSpineBegin extends KernToken {
    private static final String EMPTY = "";
    public KernSpineBegin() {
        super(EMPTY);
    }

    public KernSpineBegin(String encoding) {
        super(encoding);
    }

    @Override
    public String toString() {
        return "Spine begin";
    }
}
