package es.ua.dlsi.grfia.im4.io;

import es.ua.dlsi.grfia.im4.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.im4.core.impl.Score;

public interface IImporter {
    Score importScore(String input, ICoreAbstractFactory abstractFactory);
}
