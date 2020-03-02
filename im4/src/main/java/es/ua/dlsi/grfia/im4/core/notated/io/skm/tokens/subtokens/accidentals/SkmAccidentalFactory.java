package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.accidentals;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmAccidental;
import es.ua.dlsi.grfia.im4.utils.Factory;


public class SkmAccidentalFactory extends Factory<SkmAccidental> {
    private static SkmAccidentalFactory instance = null;

    public static SkmAccidentalFactory getInstance() {
        if (instance == null) {
            instance = new SkmAccidentalFactory();
        }
        return instance;
    }

    private SkmAccidentalFactory() {
        super("accidental");

        defaultConstructor.put(SkmAccidentalTripleFlat.SKM, SkmAccidentalTripleFlat::new);
        defaultConstructor.put(SkmAccidentalDoubleFlat.SKM, SkmAccidentalDoubleFlat::new);
        defaultConstructor.put(SkmAccidentalFlat.SKM, SkmAccidentalFlat::new);
        defaultConstructor.put(SkmAccidentalNatural.SKM, SkmAccidentalNatural::new);
        defaultConstructor.put(SkmAccidentalSharp.SKM, SkmAccidentalSharp::new);
        defaultConstructor.put(SkmAccidentalDoubleSharp.SKM, SkmAccidentalDoubleSharp::new);
        defaultConstructor.put(SkmAccidentalTripleSharp.SKM, SkmAccidentalTripleSharp::new);

    }
}
