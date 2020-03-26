package es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.core.ICoreItem;
import es.ua.dlsi.grfia.moosicae.core.ICoreObject;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmToken;

import java.util.Objects;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmCoreSymbol extends SkmToken {
    private final ICoreObject symbol;

    public SkmCoreSymbol(String encoding, ICoreObject symbol) {
        super(encoding);
        Objects.requireNonNull(symbol, "symbol");
        this.symbol = symbol;
    }

    public ICoreObject getSymbol() {
        return symbol;
    }
}
