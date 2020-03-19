package es.ua.dlsi.grfia.moosicae.utils.xml;

import java.util.LinkedList;
import java.util.Optional;

/**
 * We don't use the Java DOM tree for exporting for simplifying the processing and avoid problems due to dependencies
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class XMLTree {
    private final LinkedList<XMLPreambleElement> preamble;
    private final XMLElement root;
    private final Optional<DTDDeclaration> dtdDeclaration;

    public XMLTree(String rootName, DTDDeclaration dtdDeclaration) {
        this.root = new XMLElement(rootName);
        this.preamble = new LinkedList<>();
        this.dtdDeclaration = Optional.ofNullable(dtdDeclaration);
    }

    public XMLTree(String rootName) {
        this(rootName, null);
    }

    public void addPreamble(XMLPreambleElement preambleElement) {
        this.preamble.add(preambleElement);
    }

    public XMLElement getRoot() {
        return root;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (dtdDeclaration.isPresent()) {
            stringBuilder.append(dtdDeclaration.get().toString());
            stringBuilder.append('\n');
        }

        for (XMLPreambleElement xmlPreambleElement: preamble) {
            stringBuilder.append(xmlPreambleElement.toString());
            stringBuilder.append('\n');
        }
        stringBuilder.append(root.export(0));
        return stringBuilder.toString();
    }
}
