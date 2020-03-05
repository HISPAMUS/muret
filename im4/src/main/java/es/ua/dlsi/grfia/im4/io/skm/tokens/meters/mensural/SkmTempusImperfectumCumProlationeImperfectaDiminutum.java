package es.ua.dlsi.grfia.im4.io.skm.tokens.meters.mensural;

/**
 * Visually rendered as cut time (see https://en.wikipedia.org/wiki/Mensural_notation, unicode U+1D1CD)
 * 1 breve = 2 semibreves, 1 semibreve = 2 minim
 */
public class SkmTempusImperfectumCumProlationeImperfectaDiminutum extends SkmMensuralMeter {
    /**
     * Package visibility to be used by the factory
     */
    public static final String SKM = "*met(C|)";

    public SkmTempusImperfectumCumProlationeImperfectaDiminutum() {
        super(SKM);
    }

    @Override
    public SkmTempusImperfectumCumProlationeImperfectaDiminutum clone() {
        return new SkmTempusImperfectumCumProlationeImperfectaDiminutum();
    }

}
