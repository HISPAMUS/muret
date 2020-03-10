package es.ua.dlsi.grfia.im4.io.skm.grammar.tokens;

import es.ua.dlsi.grfia.im4.core.ISymbol;
import es.ua.dlsi.grfia.im4.io.skm.SkmToken;

public class SkmCoreSymbol extends SkmToken {
    private final ISymbol symbol;

    public SkmCoreSymbol(String encoding, ISymbol symbol) {
        super(encoding);
        this.symbol = symbol;
    }

    public ISymbol getSymbol() {
        return symbol;
    }
}
