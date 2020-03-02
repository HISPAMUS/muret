package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.accidentals.SkmAccidentalFactory;
import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.accidentals.SkmAccidentalNatural;
import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.diatonicpitches.SkmDiatonicPitchFactory;

public class SkmPitchClassFactory {
    private static SkmPitchClassFactory instance = null;

    public static SkmPitchClassFactory getInstance() {
        if (instance == null) {
            instance = new SkmPitchClassFactory();
        }
        return instance;
    }

    public SkmPitchClass create(String diatonicPitch, String accidental) throws IM4Exception {
        SkmDiatonicPitch skmDiatonicPitch = SkmDiatonicPitchFactory.getInstance().create(diatonicPitch);
        SkmAccidental skmAccidental = null;
        if (accidental == null) {
            skmAccidental = SkmAccidentalFactory.getInstance().create(accidental);
        } else {
            skmAccidental = new SkmAccidentalNatural();
        }
        return new SkmPitchClass(skmDiatonicPitch, skmAccidental);
    }
}
