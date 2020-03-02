package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.plainchant;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmPlainChant;
import es.ua.dlsi.grfia.im4.utils.Factory;


public class SkmPlainChantFactory extends Factory<SkmPlainChant> {
    private static SkmPlainChantFactory instance = null;

    public static SkmPlainChantFactory getInstance() {
        if (instance == null) {
            instance = new SkmPlainChantFactory();
        }
        return instance;
    }

    private SkmPlainChantFactory() {
        super("plain chant");

        defaultConstructor.put(SkmPlainChantBegin.SKM, SkmPlainChantBegin::new);
        defaultConstructor.put(SkmPlainChantEnd.SKM, SkmPlainChantEnd::new);
    }
}
