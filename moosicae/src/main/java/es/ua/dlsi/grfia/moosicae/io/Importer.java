package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIImporter;
import es.ua.dlsi.grfia.moosicae.io.mon.MONImporter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLImporter;

import java.io.File;
import java.io.InputStream;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Importer {
    private final ICoreAbstractFactory coreAbstractFactory;

    public Importer(ICoreAbstractFactory coreAbstractFactory) {
        this.coreAbstractFactory = coreAbstractFactory;
    }

    public IImporter create(Encodings encoding) throws IMException {
        switch (encoding) {
            case MEI:
                return new MEIImporter(coreAbstractFactory);
            case MUSICXML:
                return new MusicXMLImporter(coreAbstractFactory);
            case MON:
                return new MONImporter(coreAbstractFactory);
            default:
                throw new IMException("Cannot import from encoding " + encoding);
        }
    }

    public IScore importFromFile(File file) throws IMException {
        IImporter importer = null;
        String filename = file.getName();
        for (Encodings encoding: Encodings.values()) {
            if (filename.endsWith(encoding.getExtension())) {
                importer = create(encoding);
                break;
            }
        }

        if (importer == null) {
            throw new IMException("Uninitialized importer");
        }
        return importer.importScore(file);
    }

    public IScore importFromString(String input, Encodings encoding) throws IMException {
        IImporter importer = create(encoding);
        return importer.importScore(input);
    }

    public IScore importScore(InputStream inputStream, Encodings encoding) throws IMException {
        IImporter importer = create(encoding);
        return importer.importScore(inputStream);
    }
}
