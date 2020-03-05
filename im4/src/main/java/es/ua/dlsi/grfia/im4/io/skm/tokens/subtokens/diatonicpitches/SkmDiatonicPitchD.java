package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.diatonicpitches;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmDiatonicPitch;

public class SkmDiatonicPitchD extends SkmDiatonicPitch {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "d";

    public SkmDiatonicPitchD() {
        super(SKM);
    }

    @Override
    public SkmDiatonicPitchD clone() {
        return new SkmDiatonicPitchD();
    }
}
