package es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.core.ISymbol;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmToken;

import java.util.Objects;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmCoreSymbol extends SkmToken {
    private final ISymbol symbol;

    public SkmCoreSymbol(String encoding, ISymbol symbol) {
        super(encoding);
        Objects.requireNonNull(symbol, "symbol");
        this.symbol = symbol;
    }

    public ISymbol getSymbol() {
        return symbol;
    }
}
