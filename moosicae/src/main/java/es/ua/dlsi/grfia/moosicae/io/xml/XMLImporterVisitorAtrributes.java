package es.ua.dlsi.grfia.moosicae.io.xml;

import java.util.Iterator;
import javax.xml.stream.events.Attribute;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class XMLImporterVisitorAtrributes implements IXMLImporterVisitorParam {
    private final Iterator<Attribute> attributeIterator;

    public XMLImporterVisitorAtrributes(Iterator<Attribute> attributeIterator) {
        this.attributeIterator = attributeIterator;
    }

    public Iterator<Attribute> getAttributeIterator() {
        return attributeIterator;
    }
}
