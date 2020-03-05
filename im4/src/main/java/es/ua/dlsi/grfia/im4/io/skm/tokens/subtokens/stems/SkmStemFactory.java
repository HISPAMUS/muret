package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.stems;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmStemDirection;
import es.ua.dlsi.grfia.im4.utils.Factory;


public class SkmStemFactory extends Factory<SkmStemDirection> {
    private static SkmStemFactory instance = null;

    public static SkmStemFactory getInstance() {
        if (instance == null) {
            instance = new SkmStemFactory();
        }
        return instance;
    }

    private SkmStemFactory() {
        super("stem");

        defaultConstructor.put(SkmStemUp.SKM, SkmStemUp::new);
        defaultConstructor.put(SkmStemDown.SKM, SkmStemDown::new);

    }
}
