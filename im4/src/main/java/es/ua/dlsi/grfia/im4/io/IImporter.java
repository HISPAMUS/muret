package es.ua.dlsi.grfia.im4.io;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.IScore;

public interface IImporter {
    IScore importScore(String input) throws IM4Exception;
}
