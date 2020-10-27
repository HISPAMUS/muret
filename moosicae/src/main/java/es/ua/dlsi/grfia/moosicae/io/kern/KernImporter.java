package es.ua.dlsi.grfia.moosicae.io.kern;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.io.IImporter;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernDocument;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernSyntaxDirectedTranslation;

import java.io.File;
import java.io.InputStream;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KernImporter implements IImporter {
    private final ICoreAbstractFactory coreAbstractFactory;

    public KernImporter(ICoreAbstractFactory coreAbstractFactory) {
        this.coreAbstractFactory = coreAbstractFactory;
    }

    @Override
    public IScore importScore(String input) throws IMException {
        KernSyntaxDirectedTranslation kernSyntaxDirectedTranslation = new KernSyntaxDirectedTranslation(coreAbstractFactory);
        KernDocument skmDocument = kernSyntaxDirectedTranslation.importKern(input);
        return skmDocument.buildScore(coreAbstractFactory);
    }

    @Override
    public IScore importScore(File file) throws IMException {
        KernSyntaxDirectedTranslation kernSyntaxDirectedTranslation = new KernSyntaxDirectedTranslation(coreAbstractFactory);
        KernDocument skmDocument = kernSyntaxDirectedTranslation.importKern(file);
        return skmDocument.buildScore(coreAbstractFactory);
    }

    @Override
    public IScore importScore(InputStream inputStream) throws IMException {
        KernSyntaxDirectedTranslation kernSyntaxDirectedTranslation = new KernSyntaxDirectedTranslation(coreAbstractFactory);
        KernDocument skmDocument = kernSyntaxDirectedTranslation.importKern(inputStream);
        return skmDocument.buildScore(coreAbstractFactory);
    }
}
