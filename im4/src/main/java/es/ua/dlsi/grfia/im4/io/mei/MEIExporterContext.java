package es.ua.dlsi.grfia.im4.io.mei;

import es.ua.dlsi.grfia.im4.io.IExporterContext;
import es.ua.dlsi.grfia.im4.utils.xml.XMLElement;

/**
 * It uses the decorator pattern to add extra parameters
 */
public class MEIExporterContext implements IExporterContext {
    private final XMLElement xmlElement;

    public MEIExporterContext(XMLElement xmlElement) {
        this.xmlElement = xmlElement;
    }

    public XMLElement getXmlElement() {
        return xmlElement;
    }
}
