package es.ua.dlsi.grfia.im4.io;

import es.ua.dlsi.grfia.im4.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.IScore;

public interface IImporter {
    IScore importScore(String input, ICoreAbstractFactory abstractFactory) throws IM4Exception;
}
