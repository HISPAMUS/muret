package es.ua.dlsi.grfia.moosicae.io.lilypond;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class LilypondExporterVisitorParam {
    private final LilypondContext parent;
    private StringBuilder stringBuilder;

    public LilypondExporterVisitorParam(LilypondContext parentContext) {
        this.parent = parentContext;
    }

    public void append(String subtoken) {
        stringBuilder.append(subtoken);
    }

    public void append(int subtoken) {
        stringBuilder.append(subtoken);
    }

    public void append(char subtoken) {
        stringBuilder.append(subtoken);
    }

    public void addChild(String string) {
        this.parent.addChild(string);
    }

    public void startString() {
        this.stringBuilder = new StringBuilder();
    }

    public void finishString() {
        this.parent.addChild(stringBuilder.toString());
        this.stringBuilder = new StringBuilder();
    }
}
