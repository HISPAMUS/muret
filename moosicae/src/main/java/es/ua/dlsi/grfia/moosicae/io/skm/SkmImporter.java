package es.ua.dlsi.grfia.moosicae.io.skm;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.io.IImporter;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmDocument;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmSyntaxDirectedTranslation;

import java.io.File;
import java.io.InputStream;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmImporter implements IImporter {
    @Override
    public IScore importScore(String input) throws IMException {
        SkmSyntaxDirectedTranslation skmSyntaxDirectedTranslation = new SkmSyntaxDirectedTranslation();
        SkmDocument skmDocument = skmSyntaxDirectedTranslation.importSkm(input);
        return skmDocument.buildScore();
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
