package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.keys;


import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmKey;
import es.ua.dlsi.grfia.im4.utils.Factory;

public class SkmKeyFactory extends Factory<SkmKey> {
    private static SkmKeyFactory instance = null;

    public static SkmKeyFactory getInstance() {
        if (instance == null) {
            instance = new SkmKeyFactory();
        }
        return instance;
    }

    private SkmKeyFactory() {
        super("key");

        defaultConstructor.put(SkmKeyCMajor.SKM, SkmKeyCMajor::new);
        defaultConstructor.put(SkmKeyFMajor.SKM, SkmKeyFMajor::new);
        defaultConstructor.put(SkmKeyGMajor.SKM, SkmKeyGMajor::new);
    }
}
