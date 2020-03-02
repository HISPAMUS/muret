package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.diatonicpitches;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmDiatonicPitch;

public class SkmDiatonicPitchG extends SkmDiatonicPitch {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "g";

    public SkmDiatonicPitchG() {
        super(SKM);
    }

    @Override
    public SkmDiatonicPitchG clone() {
        return new SkmDiatonicPitchG();
    }
}
