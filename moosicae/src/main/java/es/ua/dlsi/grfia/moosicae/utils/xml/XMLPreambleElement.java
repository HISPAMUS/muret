package es.ua.dlsi.grfia.moosicae.utils.xml;

import java.util.LinkedList;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class XMLPreambleElement {
    private final String name;
    private final LinkedList<XMLAttribute> attributes;

    public XMLPreambleElement(String name) {
        this.name = name;
        this.attributes = new LinkedList<>();
    }

    public void addAttribute(String name, String value) {
        this.attributes.add(new XMLAttribute(name, value));
    }

    public String getName() {
        return name;
    }

    public LinkedList<XMLAttribute> getAttributes() {
        return attributes;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("<?");
        stringBuilder.append(name);
        for (XMLAttribute xmlAttribute: attributes) {
            stringBuilder.append(' ');
            stringBuilder.append(xmlAttribute.toString());
        }
        stringBuilder.append("?>");
        return stringBuilder.toString();
    }
}
