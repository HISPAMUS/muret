package es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernToken;

import java.util.Objects;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KernCoreSymbol extends KernToken {
    private final IMooObject symbol;

    public KernCoreSymbol(String encoding, IMooObject symbol) {
        super(encoding);
        Objects.requireNonNull(symbol, "symbol");
        this.symbol = symbol;
    }

    public IMooObject getSymbol() {
        return symbol;
    }
}
