package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.SkmItem;

public class SkmPitchClass extends SkmItem {
    private final SkmDiatonicPitch skmDiatonicPitch;
    private final SkmAccidental skmAccidental;

    public SkmPitchClass(SkmDiatonicPitch skmDiatonicPitch, SkmAccidental skmAccidental) {
        super(skmDiatonicPitch.getSkmEncoding() + skmAccidental.getSkmEncoding());
        this.skmDiatonicPitch = skmDiatonicPitch;
        this.skmAccidental = skmAccidental;
    }

    public SkmDiatonicPitch getSkmDiatonicPitch() {
        return skmDiatonicPitch;
    }

    public SkmAccidental getSkmAccidental() {
        return skmAccidental;
    }

    @Override
    public SkmPitchClass clone() {
        return new SkmPitchClass(skmDiatonicPitch, skmAccidental);
    }
}
