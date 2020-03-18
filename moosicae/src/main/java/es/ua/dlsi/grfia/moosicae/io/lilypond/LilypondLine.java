package es.ua.dlsi.grfia.moosicae.io.lilypond;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/03/2020
 */
public class LilypondLine implements ILilypondElement {
    private final String content;

    public LilypondLine(String content) {
        this.content = content;
    }

    @Override
    public String export(int tabs) {
        return ILilypondElement.generateTabs(tabs) + content;
    }
}
