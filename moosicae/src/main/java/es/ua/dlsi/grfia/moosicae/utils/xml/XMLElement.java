package es.ua.dlsi.grfia.moosicae.utils.xml;


import es.ua.dlsi.grfia.moosicae.IMRuntimeException;

import java.util.LinkedList;
import java.util.List;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
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
        if (attributes != null) {
            for (XMLAttribute xmlAttribute : attributes) {
                addAttribute(xmlAttribute);
            }
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
        this.attributes.add(attribute);  

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

        if (element == this) {
            throw new IMRuntimeException("Cannot add an element as child of itself");
        }
        this.children.add(element);
    }


    public XMLElement clone() {
        return new XMLElement(name, value, attributes, children);
    }

    private void addTabs(int tabs, StringBuilder stringBuilder) {
        for (int i=0; i<tabs; i++) {
            stringBuilder.append('\t');
        }
    }

    String export(int tabs) {
        StringBuilder stringBuilder = new StringBuilder();
        addTabs(tabs, stringBuilder);
        stringBuilder.append('<');
        stringBuilder.append(name);

        if (attributes != null) {
            for (XMLAttribute xmlAttribute : attributes) {
                stringBuilder.append(' ');
                stringBuilder.append(xmlAttribute.toString());
            }
        }

        if (children == null || children.isEmpty()) {
            stringBuilder.append('/');
            stringBuilder.append('>');
        } else {
            stringBuilder.append('>');
            stringBuilder.append('\n');

            for (XMLElement child: children) {
                stringBuilder.append(child.export(tabs+1));
            }
            addTabs(tabs, stringBuilder);
            stringBuilder.append('<');
            stringBuilder.append('/');
            stringBuilder.append(name);
            stringBuilder.append('>');
        }
        stringBuilder.append('\n');
        return stringBuilder.toString();
    }

}
