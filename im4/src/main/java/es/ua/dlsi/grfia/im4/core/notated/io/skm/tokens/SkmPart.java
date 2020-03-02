package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.SkmToken;

public class SkmPart extends SkmToken {
    /**
     * Package visibility to be used by the factory
     */
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
