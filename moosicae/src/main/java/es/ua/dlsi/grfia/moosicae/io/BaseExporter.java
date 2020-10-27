package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IScore;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class BaseExporter implements IExporter {
    @Override
    public void exportScore(IScore score, File outputFile) throws IMException, IOException {
        String exported = this.exportScore(score);
        byte[] strToBytes = exported.getBytes();
        Files.write(outputFile.toPath(), strToBytes);
    }
}
