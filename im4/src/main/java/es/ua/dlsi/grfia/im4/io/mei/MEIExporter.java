package es.ua.dlsi.grfia.im4.io.mei;

import es.ua.dlsi.grfia.im4.IClef;
import es.ua.dlsi.grfia.im4.Score;
import es.ua.dlsi.grfia.im4.utils.xml.XMLElement;
import es.ua.dlsi.grfia.im4.utils.xml.XMLTree;

public class MEIExporter {
    private final MEIExporterVisitor meiExporterVisitor;
    private final XMLTree xmlTree;

    public MEIExporter() {
        this.meiExporterVisitor = new MEIExporterVisitor();
        this.xmlTree = new XMLTree(); //TODO preamble....
    }

    public void export(Score score) {
        // for
        IClef clef = null; // ....
        XMLElement xmlElement = null;
        MEIExporterContext meiExporterContext = null;
        MEIExporterAttrOrElement meiExporterAttrOrElement = new MEIExporterAttrOrElement(meiExporterContext, true);
        clef.export(meiExporterVisitor, meiExporterAttrOrElement);
    }
}
