package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.SkmToken;

public class SkmInstrument extends SkmToken {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*I";

    private final String name;

    public SkmInstrument(String name) {
        super(SKM + name);
        this.name = name;
    }

    @Override
    public SkmInstrument clone() {
        return new SkmInstrument(name);
    }

    public String getName() {
        return name;
    }
}
