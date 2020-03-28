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

    public void addChildLine(String string) {
        this.parent.addChildLine(string);
    }
    public LilypondExporterVisitorParam addChildContext(String string, boolean useNew) {
        LilypondContext child = this.parent.addChildContext(string, useNew);
        return new LilypondExporterVisitorParam(child);
    }

    public void startString() {
        this.stringBuilder = new StringBuilder();
    }

    public void finishString() {
        this.parent.addChildLine(stringBuilder.toString());
        this.stringBuilder = new StringBuilder();
    }
}
