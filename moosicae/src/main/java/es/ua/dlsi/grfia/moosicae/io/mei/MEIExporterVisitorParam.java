package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.utils.xml.XMLElement;

/**
 * Used to add input and output parameters
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class MEIExporterVisitorParam {
    enum ExportMode {
        string, attribute, element
    };

    private ExportMode exportMode;
    private XMLElement xmlElement;
    private final StringBuilder stringBuilder;

    public MEIExporterVisitorParam(ExportMode exportMode, XMLElement xmlElement) {
        this.exportMode = exportMode;
        this.xmlElement = xmlElement;
        this.stringBuilder = new StringBuilder();
    }

    public ExportMode getExportMode() {
        return exportMode;
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

    public void append(String string) {
        this.stringBuilder.append(string);
    }
    public void append(char c) {
        this.stringBuilder.append(c);
    }
    public void append(int integer) {
        this.stringBuilder.append(integer);
    }

    public String getStringBuilderValue() {
        return stringBuilder.toString();
    }
}
