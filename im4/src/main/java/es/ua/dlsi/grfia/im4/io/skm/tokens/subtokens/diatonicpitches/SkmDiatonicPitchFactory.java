package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.diatonicpitches;

import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmDiatonicPitch;
import es.ua.dlsi.grfia.im4.utils.Factory;


public class SkmDiatonicPitchFactory extends Factory<SkmDiatonicPitch> {
    private static SkmDiatonicPitchFactory instance = null;

    public static SkmDiatonicPitchFactory getInstance() {
        if (instance == null) {
            instance = new SkmDiatonicPitchFactory();
        }
        return instance;
    }

    private SkmDiatonicPitchFactory() {
        super("diatonic pitch");

        defaultConstructor.put(SkmDiatonicPitchA.SKM, SkmDiatonicPitchA::new);
        defaultConstructor.put(SkmDiatonicPitchB.SKM, SkmDiatonicPitchB::new);
        defaultConstructor.put(SkmDiatonicPitchC.SKM, SkmDiatonicPitchC::new);
        defaultConstructor.put(SkmDiatonicPitchD.SKM, SkmDiatonicPitchD::new);
        defaultConstructor.put(SkmDiatonicPitchE.SKM, SkmDiatonicPitchE::new);
        defaultConstructor.put(SkmDiatonicPitchF.SKM, SkmDiatonicPitchF::new);
        defaultConstructor.put(SkmDiatonicPitchG.SKM, SkmDiatonicPitchG::new);
    }
}
