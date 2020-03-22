package es.ua.dlsi.grfia.moosicae.io.xml;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class XMLImporterVisitorCharacters implements IXMLImporterVisitorParam {
    private final String characters;

    public XMLImporterVisitorCharacters(String characters) {
        this.characters = characters;
    }

    public String getCharacters() {
        return characters;
    }
}
