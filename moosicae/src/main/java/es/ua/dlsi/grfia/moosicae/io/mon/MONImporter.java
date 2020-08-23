package es.ua.dlsi.grfia.moosicae.io.mon;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.io.IImporter;

import java.io.File;
import java.io.InputStream;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/08/2020
 */
public class MONImporter implements IImporter {
    public MONImporter(ICoreAbstractFactory coreAbstractFactory) {
    }

    @Override
    public IScore importScore(String input) throws IMException {
        return null;
    }

    @Override
    public IScore importScore(File file) throws IMException {
        return null;
    }

    @Override
    public IScore importScore(InputStream inputStream) throws IMException {
        return null;
    }
}
