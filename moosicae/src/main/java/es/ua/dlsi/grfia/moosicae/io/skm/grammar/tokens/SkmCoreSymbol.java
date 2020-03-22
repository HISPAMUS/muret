package es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.core.ICoreItem;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmToken;

import java.util.Objects;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmCoreSymbol extends SkmToken {
    private final ICoreItem symbol;

    public SkmCoreSymbol(String encoding, ICoreItem symbol) {
        super(encoding);
        Objects.requireNonNull(symbol, "symbol");
        this.symbol = symbol;
    }

    public ICoreItem getSymbol() {
        return symbol;
    }
}
