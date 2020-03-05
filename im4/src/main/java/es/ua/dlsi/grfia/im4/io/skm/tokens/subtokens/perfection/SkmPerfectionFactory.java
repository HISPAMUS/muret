package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.perfection;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmPerfection;
import es.ua.dlsi.grfia.im4.utils.Factory;


public class SkmPerfectionFactory extends Factory<SkmPerfection> {
    private static SkmPerfectionFactory instance = null;

    public static SkmPerfectionFactory getInstance() {
        if (instance == null) {
            instance = new SkmPerfectionFactory();
        }
        return instance;
    }

    private SkmPerfectionFactory() {
        super("perfection");

        defaultConstructor.put(SkmPerfectum.SKM, SkmPerfectum::new);
        defaultConstructor.put(SkmImperfectum.SKM, SkmImperfectum::new);

    }
}
