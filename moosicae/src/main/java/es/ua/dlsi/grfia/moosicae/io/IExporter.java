package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IScore;

import java.io.File;
import java.io.IOException;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IExporter {
    String exportScore(IScore score) throws IMException;
    void exportScore(IScore score, File outputFile) throws IMException, IOException;
}
