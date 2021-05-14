package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IScore;

import java.io.File;
import java.io.IOException;

/**
 * It converts from formats to formats
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 12/5/21
 */
public class FormatConverter {
    public void convert(File fromFile, File toFile) throws IMException, IOException {
        Importer importer = new Importer();
        IScore score = importer.importFromFile(fromFile);

        Exporter exporter = new Exporter();
        exporter.export(score, toFile);
    }
}
