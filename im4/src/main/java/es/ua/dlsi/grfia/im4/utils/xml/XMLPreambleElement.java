package es.ua.dlsi.grfia.im4.utils.xml;

import java.util.LinkedList;

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
}
