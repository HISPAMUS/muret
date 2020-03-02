package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.diatonicpitches;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmDiatonicPitch;

public class SkmDiatonicPitchF extends SkmDiatonicPitch {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "f";

    public SkmDiatonicPitchF() {
        super(SKM);
    }

    @Override
    public SkmDiatonicPitchF clone() {
        return new SkmDiatonicPitchF();
    }
}
