package es.ua.dlsi.grfia.im4.io.skm;

import es.ua.dlsi.grfia.im4.core.IClef;
import es.ua.dlsi.grfia.im4.core.impl.Score;
import es.ua.dlsi.grfia.im4.io.IExporter;


import java.io.File;

public class SkmExporter implements IExporter {
    private final SkmExporterVisitor meiExporterVisitor;

    public SkmExporter() {
        this.meiExporterVisitor = new SkmExporterVisitor();
    }

    public void export(Score score) {
    }

    @Override
    public String exportScore(Score score) {
        // for
        IClef clef = null; // ....
        SkmExporterContext skmExporterContext = null;
        /// clef.export(meiExporterVisitor, skmExporterContext);
        return skmExporterContext.toString();
    }

    @Override
    public void exportScore(Score score, File file) {
        //TODO write to file
    }
}
