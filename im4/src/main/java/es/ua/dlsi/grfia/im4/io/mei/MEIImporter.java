package es.ua.dlsi.grfia.im4.io.mei;

import es.ua.dlsi.grfia.im4.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.im4.core.impl.Score;
import es.ua.dlsi.grfia.im4.io.AbstractImporter;

public class MEIImporter extends AbstractImporter {
    protected MEIImporter(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
    }

    @Override
    public Score importScore(String input) {
        return null;
    }
}
