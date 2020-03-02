package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.diatonicpitches;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmDiatonicPitch;

public class SkmDiatonicPitchE extends SkmDiatonicPitch {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "e";

    public SkmDiatonicPitchE() {
        super(SKM);
    }

    @Override
    public SkmDiatonicPitchE clone() {
        return new SkmDiatonicPitchE();
    }
}
