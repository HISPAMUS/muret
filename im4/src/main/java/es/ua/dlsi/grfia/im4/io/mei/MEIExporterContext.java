package es.ua.dlsi.grfia.im4.io.mei;

import es.ua.dlsi.grfia.im4.io.IExporterContext;
import es.ua.dlsi.grfia.im4.utils.xml.XMLElement;

/**
 * It uses the decorator pattern to add extra parameters
 */
public class MEIExporterContext implements IExporterContext {
    private final XMLElement xmlElement;
    private final boolean resultAddedAsAttribute;

    public MEIExporterContext(XMLElement xmlElement, boolean resultAddedAsAttribute) {
        this.xmlElement = xmlElement;
        this.resultAddedAsAttribute = resultAddedAsAttribute;
    }

    public XMLElement getXmlElement() {
        return xmlElement;
    }

    public boolean isResultAddedAsAttribute() {
        return resultAddedAsAttribute;
    }
}
