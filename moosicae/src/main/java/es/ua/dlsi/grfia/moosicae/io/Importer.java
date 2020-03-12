package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.core.IScore;

import java.io.File;

public class Importer {
    IImporter importer;

    public Importer(IImporter importer) {
        this.importer = importer;
    }

    public IScore importFromFile(File file) {
        //TODO
        return null;
    }
}
