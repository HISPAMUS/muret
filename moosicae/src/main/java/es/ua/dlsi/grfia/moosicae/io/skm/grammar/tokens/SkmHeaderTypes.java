package es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens;

public enum SkmHeaderTypes {
    skern ("**skern"),
    smens ("**smens"),
    dynamics ("**dyn"),
    harmonies ("**harm"),
    text ("**text"),
    id ("**id");

    private final String encoding;

    SkmHeaderTypes(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }
}
