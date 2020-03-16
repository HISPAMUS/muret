package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.utils.xml.XMLElement;

/**
 * Used to add input and output parameters
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class MEIExporterVisitorParam {
    private boolean exportAsAttributes;
    private XMLElement xmlElement;

    public MEIExporterVisitorParam(boolean exportAsAttributes, XMLElement xmlElement) {
        this.exportAsAttributes = exportAsAttributes;
        this.xmlElement = xmlElement;
    }

    public boolean isExportAsAttributes() {
        return exportAsAttributes;
    }

    public void addAttribute(String name, String value) {
        xmlElement.addAttribute(name, value);
    }

    public void addChild(XMLElement child) {
        xmlElement.addChild(xmlElement);
    }

    public void addChild(String childElementName) {
        xmlElement.addChild(childElementName);
    }
}
