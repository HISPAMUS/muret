package es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmToken;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmPart extends SkmToken {
    private final int number;

    public SkmPart(String encoding, int number) {
        super(encoding);
        this.number = number;
    }

    @Override
    public SkmPart clone() {
        return new SkmPart(getEncoding(), number);
    }

    public int getNumber() {
        return number;
    }
}
