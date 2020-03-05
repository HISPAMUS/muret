package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.alterationqualifiers;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmAlterationQualifier;
import es.ua.dlsi.grfia.im4.utils.Factory;


public class SkmAlterationQualifierFactory extends Factory<SkmAlterationQualifier> {
    private static SkmAlterationQualifierFactory instance = null;

    public static SkmAlterationQualifierFactory getInstance() {
        if (instance == null) {
            instance = new SkmAlterationQualifierFactory();
        }
        return instance;
    }

    private SkmAlterationQualifierFactory() {
        super("alteration qualifier");

        defaultConstructor.put(SkmAlterationHidden.SKM, SkmAlterationHidden::new);
        defaultConstructor.put(SkmAlterationCautionary.SKM, SkmAlterationCautionary::new);
        defaultConstructor.put(SkmAlterationFicta.SKM, SkmAlterationFicta::new);
        defaultConstructor.put(SkmAlterationEditorial.SKM, SkmAlterationEditorial::new);

    }
}
