package es.ua.dlsi.grfia.im4.io;

import es.ua.dlsi.grfia.im4.core.IScore;

import java.io.File;

public interface IExporter {
    String exportScore(IScore score);
    void exportScore(IScore score, File file);
}
