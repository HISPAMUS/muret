package es.ua.dlsi.grfia.im4.utils.xml;


import java.util.LinkedList;
import java.util.List;

public class XMLElement {
    private final String name;
    private LinkedList<XMLAttribute> attributes;
    private final String value;
    private LinkedList<XMLElement> children;

    public XMLElement(String name, String value) {
        this.name = name;
        this.value = value;
        this.attributes = null;
        this.children = null;
    }

    public XMLElement(String name) {
        this.name = name;
        this.value = null;
        this.attributes = null;
        this.children = null;
    }

    private XMLElement(String name, String value, List<XMLAttribute> attributes, LinkedList<XMLElement> children) {
        this(name, value);
        for (XMLAttribute xmlAttribute: attributes) {
            addAttribute(xmlAttribute);
        }
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public XMLElement addAttribute(String name, String value) {
        this.addAttribute(new XMLAttribute(name, value));
        return this;
    }

    public void addAttribute(XMLAttribute attribute) {

        if (this.attributes == null) {
            this.attributes = new LinkedList<>();
        }
        this.attributes.add(attribute.clone());

    }

    public XMLElement addChild(String elementName) {
        XMLElement child = new XMLElement(elementName);
        addChild(child);
        return child;
    }

    public void addChild(XMLElement element) {
        if (this.children == null) {
            this.children = new LinkedList<>();
        }

        this.children.add(element.clone());
    }


    public XMLElement clone() {
        return new XMLElement(name, value, attributes, children);
    }
}
