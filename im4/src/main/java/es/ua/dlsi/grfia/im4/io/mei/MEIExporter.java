package es.ua.dlsi.grfia.im4.io.mei;

import es.ua.dlsi.grfia.im4.core.IClef;
import es.ua.dlsi.grfia.im4.core.Score;
import es.ua.dlsi.grfia.im4.io.IExporter;
import es.ua.dlsi.grfia.im4.utils.xml.XMLElement;
import es.ua.dlsi.grfia.im4.utils.xml.XMLTree;

import java.io.File;

public class MEIExporter implements IExporter {
    private final MEIExporterVisitor meiExporterVisitor;
    private final XMLTree xmlTree;

    public MEIExporter() {
        this.meiExporterVisitor = new MEIExporterVisitor();
        this.xmlTree = new XMLTree(); //TODO preamble....
    }

    public void export(Score score) {
    }

    @Override
    public String exportScore(Score score) {
        // for
        IClef clef = null; // ....
        XMLElement xmlElement = null;
        MEIExporterContext meiExporterContext = null;
        clef.export(meiExporterVisitor, meiExporterContext);
        return xmlTree.toString();
    }

    @Override
    public void exportScore(Score score, File file) {
        //TODO write to file
    }
}
