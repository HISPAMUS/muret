package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.figures;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmFigure;
import es.ua.dlsi.grfia.im4.utils.Factory;


public class SkmFigureFactory extends Factory<SkmFigure> {
    private static SkmFigureFactory instance = null;

    public static SkmFigureFactory getInstance() {
        if (instance == null) {
            instance = new SkmFigureFactory();
        }
        return instance;
    }

    private SkmFigureFactory() {
        super("figure");

        // mensural
        defaultConstructor.put(SkmMaxima.SKM, SkmMaxima::new);
        defaultConstructor.put(SkmLonga.SKM, SkmLonga::new);
        defaultConstructor.put(SkmBreve.SKM, SkmBreve::new);
        defaultConstructor.put(SkmSemibreve.SKM, SkmSemibreve::new);
        defaultConstructor.put(SkmMinima.SKM, SkmMinima::new);
        defaultConstructor.put(SkmSeminima.SKM, SkmSeminima::new);
        defaultConstructor.put(SkmFusa.SKM, SkmFusa::new);
        defaultConstructor.put(SkmSemifusa.SKM, SkmSemifusa::new);

        // modern
        defaultConstructor.put(SkmDoubleWhole.SKM, SkmDoubleWhole::new);
        defaultConstructor.put(SkmWhole.SKM, SkmWhole::new);
        defaultConstructor.put(SkmHalf.SKM, SkmHalf::new);
        defaultConstructor.put(SkmQuarter.SKM, SkmQuarter::new);
        defaultConstructor.put(SkmEighth.SKM, SkmEighth::new);
        defaultConstructor.put(SkmSixteenth.SKM, SkmSixteenth::new);
        defaultConstructor.put(SkmThirtySecond.SKM, SkmThirtySecond::new);
        defaultConstructor.put(SkmSixtyFourth.SKM, SkmSixtyFourth::new);
        defaultConstructor.put(SkmOneHundredTwentyEighth.SKM, SkmOneHundredTwentyEighth::new);
        defaultConstructor.put(SkmTwoHundredFiftySixth.SKM, SkmTwoHundredFiftySixth::new);
    }
}
