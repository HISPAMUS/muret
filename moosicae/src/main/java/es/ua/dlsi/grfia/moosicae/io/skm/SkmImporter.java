package es.ua.dlsi.grfia.moosicae.io.skm;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.io.AbstractImporter;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmDocument;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmSyntaxDirectedTranslation;

import java.io.File;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmImporter extends AbstractImporter {
    /**
     * It uses the default core factory
     */
    public SkmImporter() {
    }

    public SkmImporter(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
    }

    @Override
    public IScore importScore(String input) throws IMException {
        SkmSyntaxDirectedTranslation skmSyntaxDirectedTranslation = new SkmSyntaxDirectedTranslation(coreAbstractFactory);
        SkmDocument skmDocument = skmSyntaxDirectedTranslation.importSkm(input);
        return skmDocument.buildScore(coreAbstractFactory);
    }

    @Override
    public IScore importScore(File file) throws IMException {
        throw new UnsupportedOperationException("TODO");
    }
}
