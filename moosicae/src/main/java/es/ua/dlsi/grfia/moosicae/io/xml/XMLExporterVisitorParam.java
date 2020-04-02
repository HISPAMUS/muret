package es.ua.dlsi.grfia.moosicae.io.xml;

import es.ua.dlsi.grfia.moosicae.utils.xml.XMLElement;

/**
 * Used to add input and output parameters
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class XMLExporterVisitorParam {

    private XMLParamExportMode XMLParamExportMode;
    private XMLElement xmlElement;
    private final StringBuilder stringBuilder;

    public XMLExporterVisitorParam(XMLParamExportMode XMLParamExportMode) {
        this.XMLParamExportMode = XMLParamExportMode;
        this.xmlElement = null;
        this.stringBuilder = new StringBuilder();
    }

    public XMLExporterVisitorParam(XMLParamExportMode XMLParamExportMode, XMLElement xmlElement) {
        this.XMLParamExportMode = XMLParamExportMode;
        this.xmlElement = xmlElement;
        this.stringBuilder = new StringBuilder();
    }

    public XMLExporterVisitorParam(XMLParamExportMode XMLParamExportMode, String childElementName) {
        this.XMLParamExportMode = XMLParamExportMode;
        this.xmlElement = new XMLElement(childElementName);
        this.stringBuilder = new StringBuilder();
    }

    public XMLParamExportMode getXMLParamExportMode() {
        return XMLParamExportMode;
    }

    public void addAttribute(String name, String value) {
        xmlElement.addAttribute(name, value);
    }

    public void addChild(XMLElement child) {
        xmlElement.addChild(child);
    }

    public XMLElement addChild(String childElementName) {
        return xmlElement.addChild(childElementName);
    }

    public XMLElement addChild(String childElementName, String value) {
        return xmlElement.addChild(childElementName, value);
    }

    public XMLExporterVisitorParam addChild(XMLParamExportMode xmlParamExportMode, String childElementName) {
        return new XMLExporterVisitorParam(xmlParamExportMode, addChild(childElementName));
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
