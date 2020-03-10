package es.ua.dlsi.grfia.im4.io.skm.grammar.tokens;

import es.ua.dlsi.grfia.im4.io.skm.grammar.SkmToken;

public class SkmPart extends SkmToken {
    static final String SKM = "*part";

    private final int number;

    public SkmPart(int number) {
        super(SKM + number);
        this.number = number;
    }

    @Override
    public SkmPart clone() {
        return new SkmPart(number);
    }

    public int getNumber() {
        return number;
    }
}
