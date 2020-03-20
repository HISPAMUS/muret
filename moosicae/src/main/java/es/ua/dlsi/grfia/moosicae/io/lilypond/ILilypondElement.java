package es.ua.dlsi.grfia.moosicae.io.lilypond;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/03/2020
 */
public interface ILilypondElement {
    String export(int tabs);

    static String generateTabs(int ntabs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<ntabs; i++) {
            stringBuilder.append('\t');
        }
        return stringBuilder.toString();
    }
}
