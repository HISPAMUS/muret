package es.ua.dlsi.grfia.im4.io;

import es.ua.dlsi.grfia.im4.core.IScore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Exporter {
    private final IExporter exporter;

    public Exporter(IExporter exporter) {
        this.exporter = exporter;
    }

    public String export(IScore score) {
        return this.exporter.exportScore(score);
    }

    public void export(IScore score, Path path) throws IOException {
        String str = export(score);
        byte[] strToBytes = str.getBytes();
        Files.write(path, strToBytes);
    }

}
