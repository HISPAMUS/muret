package es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.core.ISymbol;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmToken;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
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
