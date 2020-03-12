package es.ua.dlsi.grfia.moosicae.utils.xml;

import java.util.LinkedList;

/**
 * We don't use the Java DOM tree for simplifying the processing and avoid problems due to dependencies
 */
public class XMLTree {
    private final LinkedList<XMLPreambleElement> preamble;
    private final XMLElement root;

    public XMLTree(String rootName) {
        this.root = new XMLElement(rootName);
        this.preamble = new LinkedList<>();
    }

    public void addPreamble(XMLPreambleElement preambleElement) {
        this.preamble.add(preambleElement);
    }

    public XMLElement getRoot() {
        return root;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (XMLPreambleElement xmlPreambleElement: preamble) {
            stringBuilder.append(xmlPreambleElement.toString());
            stringBuilder.append('\n');
        }
        stringBuilder.append(root.export(0));
        return stringBuilder.toString();
    }
}
