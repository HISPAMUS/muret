package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IScore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Exporter {
    private final IExporter exporter;

    public Exporter(IExporter exporter) {
        this.exporter = exporter;
    }

    public String export(IScore score) throws IMException {
        return this.exporter.exportScore(score);
    }

    public void export(IScore score, Path path) throws IOException, IMException {
        String str = export(score);
        byte[] strToBytes = str.getBytes();
        Files.write(path, strToBytes);
    }

}
