package es.ua.dlsi.grfia.im4.io.mei;

import es.ua.dlsi.grfia.im4.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.im4.core.IScore;
import es.ua.dlsi.grfia.im4.io.AbstractImporter;

public class MEIImporter extends AbstractImporter {
    public MEIImporter(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
    }

    @Override
    public IScore importScore(String input) {
        return coreAbstractFactory.createScore(); //TODO
    }
}
