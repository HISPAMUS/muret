package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.diatonicpitches;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmDiatonicPitch;

public class SkmDiatonicPitchB extends SkmDiatonicPitch {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "b";

    public SkmDiatonicPitchB() {
        super(SKM);
    }

    @Override
    public SkmDiatonicPitchB clone() {
        return new SkmDiatonicPitchB();
    }
}
