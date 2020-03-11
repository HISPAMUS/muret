package es.ua.dlsi.grfia.im4.io.skm;

import es.ua.dlsi.grfia.im4.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.IScore;
import es.ua.dlsi.grfia.im4.io.AbstractImporter;
import es.ua.dlsi.grfia.im4.io.skm.grammar.SkmDocument;
import es.ua.dlsi.grfia.im4.io.skm.grammar.SkmSyntaxDirectedTranslation;

public class SkmImporter extends AbstractImporter {
    public SkmImporter(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
    }

    @Override
    public IScore importScore(String input) throws IM4Exception {
        SkmSyntaxDirectedTranslation skmSyntaxDirectedTranslation = new SkmSyntaxDirectedTranslation(coreAbstractFactory);
        SkmDocument skmDocument = skmSyntaxDirectedTranslation.importSkm(input);
        return skmDocument.buildScore(coreAbstractFactory);
    }
}
