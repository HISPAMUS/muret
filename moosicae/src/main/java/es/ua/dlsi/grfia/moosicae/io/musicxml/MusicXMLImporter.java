package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.io.IImporter;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/03/2020
 */
public class MusicXMLImporter implements IImporter {
    private final ICoreAbstractFactory abstractFactory;

    public MusicXMLImporter(ICoreAbstractFactory abstractFactory) {
        this.abstractFactory = abstractFactory;
    }

    @Override
    public IScore importScore(String input) throws IMException {
        return null;
    }
}
