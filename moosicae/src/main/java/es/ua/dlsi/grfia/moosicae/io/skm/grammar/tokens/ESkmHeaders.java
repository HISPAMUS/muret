package es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public enum ESkmHeaders {
    skern ("**skern"),
    smens ("**smens"),
    dynamics ("**dyn"),
    harmonies ("**harm"),
    text ("**text"),
    id ("**id");

    private final String encoding;

    ESkmHeaders(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }
}
