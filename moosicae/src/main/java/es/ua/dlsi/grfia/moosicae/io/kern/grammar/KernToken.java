package es.ua.dlsi.grfia.moosicae.io.kern.grammar;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KernToken {
    private final String encoding;

    public KernToken(String encoding) {
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
