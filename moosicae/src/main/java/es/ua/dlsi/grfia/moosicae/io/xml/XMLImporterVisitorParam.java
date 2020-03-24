package es.ua.dlsi.grfia.moosicae.io.xml;

import javax.xml.stream.events.Attribute;
import java.util.Iterator;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class XMLImporterVisitorParam {
    private final Iterator<Attribute> attributeIterator;
    private final String characters;

    public XMLImporterVisitorParam(Iterator<Attribute> attributeIterator) {
        this.attributeIterator = attributeIterator;
        this.characters = null;
    }

    public XMLImporterVisitorParam(String characters) {
        this.characters = characters;
        this.attributeIterator = null;
    }

    public Optional<Iterator<Attribute>> getAttributeIterator() {
        return Optional.ofNullable(attributeIterator);
    }

    public Optional<String> getCharacters() {
        return Optional.ofNullable(characters);
    }

}
