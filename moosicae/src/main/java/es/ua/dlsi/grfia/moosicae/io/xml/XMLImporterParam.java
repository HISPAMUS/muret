package es.ua.dlsi.grfia.moosicae.io.xml;

import javax.xml.stream.events.Attribute;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class XMLImporterParam {
    private final String characters;
    private final HashMap<String, String> attributes;

    public XMLImporterParam(Iterator<Attribute> attributeIterator) {
        this.attributes = new HashMap<>();
        for (Iterator<Attribute> iterator = attributeIterator; iterator.hasNext(); ) {
            Attribute attribute = iterator.next();
            attributes.put(attribute.getName().getLocalPart(), attribute.getValue());
        }
        this.characters = null;
    }

    public XMLImporterParam(String characters) {
        this.characters = characters;
        this.attributes = null;
    }

    public Optional<String> getCharacters() {
        return Optional.ofNullable(characters);
    }

    public Optional<String> getAttribute(String name) {
        if (attributes != null) {
            String value = attributes.get(name);
            return Optional.ofNullable(value);
        } else {
            return Optional.empty();
        }
    }

    public boolean hasAttributes() {
        return attributes != null && !attributes.isEmpty();
    }

}
