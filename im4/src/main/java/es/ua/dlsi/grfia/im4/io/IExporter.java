package es.ua.dlsi.grfia.im4.io;

import es.ua.dlsi.grfia.im4.core.Score;

import java.io.File;

public interface IExporter {
    String exportScore(Score score);
    void exportScore(Score score, File file);
}
