package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IScore;

import java.io.File;
import java.io.InputStream;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IImporter {
    IScore importScore(String input) throws IMException;
    IScore importScore(File file) throws IMException;
    IScore importScore(InputStream inputStream) throws IMException;
}
