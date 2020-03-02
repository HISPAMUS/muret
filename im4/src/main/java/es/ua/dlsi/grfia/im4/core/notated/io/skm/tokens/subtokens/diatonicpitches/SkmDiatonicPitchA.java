package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.diatonicpitches;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmDiatonicPitch;

public class SkmDiatonicPitchA extends SkmDiatonicPitch {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "a";

    public SkmDiatonicPitchA() {
        super(SKM);
    }

    @Override
    public SkmDiatonicPitchA clone() {
        return new SkmDiatonicPitchA();
    }
}
