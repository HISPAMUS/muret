package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IScore;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IImporter {
    IScore importScore(String input) throws IMException;
}
