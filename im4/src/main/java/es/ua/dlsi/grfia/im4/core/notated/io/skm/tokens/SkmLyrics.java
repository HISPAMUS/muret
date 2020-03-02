package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.SkmToken;

public class SkmLyrics extends SkmToken {
    private final String text;

    public SkmLyrics(String text) {
        super(text);
        this.text = text;
    }

    @Override
    public SkmLyrics clone() {
        return new SkmLyrics(text);
    }
}
