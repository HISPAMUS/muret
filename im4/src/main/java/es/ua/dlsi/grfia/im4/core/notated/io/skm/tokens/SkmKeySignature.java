package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens;

import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;
import es.ua.dlsi.grfia.im4.core.notated.io.skm.SkmToken;
import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmPitchClass;

public class SkmKeySignature extends SkmToken {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*k[]";

    private final SkmPitchClass[] diatonicPitches;

    public SkmKeySignature(SkmPitchClass[] diatonicPitches) {
        super(buildSkmEncoding(diatonicPitches));
        if (diatonicPitches == null) {
            this.diatonicPitches = new SkmPitchClass[0];
        } else {
            this.diatonicPitches = diatonicPitches.clone();
        }
    }

    private static String buildSkmEncoding(SkmPitchClass[] diatonicPitches) {
        StringBuilder stringBuilder = new StringBuilder("*k[");
        for (SkmPitchClass diatonicPitch: diatonicPitches) {
            stringBuilder.append(diatonicPitch.getSkmEncoding());
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public SkmPitchClass getPitchClass(int index) {
        if (index < 0 || index >= diatonicPitches.length) {
            throw new IM4RuntimeException("Invalid index " + index + " for " + diatonicPitches.length + " diatonic pitches");
        }
        return diatonicPitches[index];
    }

    public int getNumPitchClasses() {
        return diatonicPitches.length;
    }
    @Override
    public SkmKeySignature clone() {
        return new SkmKeySignature(diatonicPitches);
    }
}
