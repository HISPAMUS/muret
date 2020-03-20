package es.ua.dlsi.grfia.moosicae.io.skm.grammar;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmToken {
    private final String encoding;

    public SkmToken(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }

    @Override
    public String toString() {
        return encoding;
    }
}
