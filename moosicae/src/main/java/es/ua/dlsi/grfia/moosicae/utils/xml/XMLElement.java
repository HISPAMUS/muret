package es.ua.dlsi.grfia.moosicae.utils.xml;


import es.ua.dlsi.grfia.moosicae.IMRuntimeException;

import java.util.Comparator;
import java.util.HashMap;
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

    public XMLElement addChild(String elementName, String content) {
        XMLElement child = new XMLElement(elementName, content);
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

        if (value == null && (children == null || children.isEmpty())) {
            stringBuilder.append('/');
            stringBuilder.append('>');
        } else {
            stringBuilder.append('>');

            if (value != null) {
                stringBuilder.append(value);
            }

            if (children != null && !children.isEmpty()) {
                stringBuilder.append('\n');
                for (XMLElement child : children) {
                    stringBuilder.append(child.export(tabs + 1));
                }
                addTabs(tabs, stringBuilder);
            }
            stringBuilder.append('<');
            stringBuilder.append('/');
            stringBuilder.append(name);
            stringBuilder.append('>');
        }
        stringBuilder.append('\n');
        return stringBuilder.toString();
    }


    /**
     *
     * @param childrenOrder The key contains the element name, the value the ascending ordering
     */
    public void sortElements(HashMap<String, Integer> childrenOrder) {
        this.children.sort(new Comparator<XMLElement>() {
            @Override
            public int compare(XMLElement o1, XMLElement o2) {
                Integer o1Order = childrenOrder.get(o1.getName());
                Integer o2Order = childrenOrder.get(o2.getName());
                if (o1Order == null) {
                    o1Order = o1.hashCode();
                }
                if (o2Order == null) {
                    o2Order = o2.hashCode();
                }
                return o1Order-o2Order;
            }
        });
    }
}
