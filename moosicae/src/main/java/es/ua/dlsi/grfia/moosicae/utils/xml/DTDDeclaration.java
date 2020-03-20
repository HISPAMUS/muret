package es.ua.dlsi.grfia.moosicae.utils.xml;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/03/2020
 */
public class DTDDeclaration {
    private final String rootName;
    private final String type;
    private final String [] strings;

    public DTDDeclaration(String rootName, String type, String ... strings) {
        this.rootName = rootName;
        this.type = type;
        this.strings = strings;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE ");
        stringBuilder.append(rootName);
        stringBuilder.append(' ');
        stringBuilder.append(type);
        for (String string: strings) {
            stringBuilder.append(' ');
            stringBuilder.append('"');
            stringBuilder.append(string);
            stringBuilder.append('"');
        }
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}
