package es.ua.dlsi.grfia.im4.io.skm;

import es.ua.dlsi.grfia.im4.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.IScore;
import es.ua.dlsi.grfia.im4.core.impl.Score;
import es.ua.dlsi.grfia.im4.io.IImporter;
import es.ua.dlsi.grfia.im4.io.skm.grammar.SkmDocument;
import es.ua.dlsi.grfia.im4.io.skm.grammar.SkmSyntaxDirectedTranslation;

public class SkmImporter implements IImporter {
    @Override
    public IScore importScore(String input, ICoreAbstractFactory abstractFactory) throws IM4Exception {
        SkmSyntaxDirectedTranslation skmSyntaxDirectedTranslation = new SkmSyntaxDirectedTranslation(abstractFactory);
        SkmDocument skmDocument = skmSyntaxDirectedTranslation.importSkm(input);
        return skmDocument.buildScore(abstractFactory);
    }
}
