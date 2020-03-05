package es.ua.dlsi.grfia.im4.io;


import es.ua.dlsi.grfia.im4.core.Score;

import java.io.File;

public interface IImporter {
    Score importScore(String input);
    Score importScore(File file);
}
