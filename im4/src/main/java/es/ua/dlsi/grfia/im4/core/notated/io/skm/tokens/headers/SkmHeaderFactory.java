package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.headers;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmHeader;
import es.ua.dlsi.grfia.im4.utils.Factory;


public class SkmHeaderFactory extends Factory<SkmHeader> {
    private static SkmHeaderFactory instance = null;

    public static SkmHeaderFactory getInstance() {
        if (instance == null) {
            instance = new SkmHeaderFactory();
        }
        return instance;
    }

    private SkmHeaderFactory() {
        super("header");

        defaultConstructor.put(SkmSMens.SKM, SkmSMens::new);
        defaultConstructor.put(SkmSKern.SKM, SkmSKern::new);
        defaultConstructor.put(SkmDynamics.SKM, SkmDynamics::new);
        defaultConstructor.put(SkmText.SKM, SkmText::new);
        defaultConstructor.put(SkmHarmonies.SKM, SkmHarmonies::new);

    }
}
