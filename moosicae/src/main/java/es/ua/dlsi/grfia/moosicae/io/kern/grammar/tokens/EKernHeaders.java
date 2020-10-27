package es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public enum EKernHeaders {
    kern ("**kern"),
    mens ("**mens"),
    skern ("**skern"),
    smens ("**smens"),
    dynamics ("**dyn"),
    harmonies ("**harm"),
    text ("**text"),
    id ("**id");

    private final String encoding;

    EKernHeaders(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }
}
