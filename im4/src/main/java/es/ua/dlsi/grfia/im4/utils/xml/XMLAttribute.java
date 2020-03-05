package es.ua.dlsi.grfia.im4.utils.xml;

import java.util.Objects;

public class XMLAttribute {
    private final String name;
    private final String value;

    public XMLAttribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XMLAttribute that = (XMLAttribute) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    public XMLAttribute clone() {
        return new XMLAttribute(name, value);
    }
}
