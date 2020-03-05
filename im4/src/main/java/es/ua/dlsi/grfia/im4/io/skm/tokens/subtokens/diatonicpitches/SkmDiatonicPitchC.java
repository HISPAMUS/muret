package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.diatonicpitches;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmDiatonicPitch;

public class SkmDiatonicPitchC extends SkmDiatonicPitch {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "c";

    public SkmDiatonicPitchC() {
        super(SKM);
    }

    @Override
    public SkmDiatonicPitchC clone() {
        return new SkmDiatonicPitchC();
    }
}
