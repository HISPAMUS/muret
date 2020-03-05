package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens;

import es.ua.dlsi.grfia.im4.io.skm.SkmItem;

public class SkmScientificPitch extends SkmItem {
    private final SkmDiatonicPitch skmDiatonicPitch;
    private final SkmAlteration skmAlteration;
    private final int octave;

    public SkmScientificPitch(SkmDiatonicPitch skmDiatonicPitch, SkmAlteration skmAlteration, int octave) {
        super(buildSkmEncoding(skmDiatonicPitch, skmAlteration, octave));
        this.skmDiatonicPitch = skmDiatonicPitch;
        this.skmAlteration = skmAlteration;
        this.octave = octave;
    }

    @Override
    public SkmScientificPitch clone() {
        return new SkmScientificPitch(skmDiatonicPitch, skmAlteration, octave);
    }

    private static String buildSkmEncoding(SkmDiatonicPitch skmDiatonicPitch, SkmAlteration skmAlteration, int octave) {
        StringBuilder sb = new StringBuilder();

        String middleOctaveNote = skmDiatonicPitch.getSkmEncoding();

        if (octave < 4) {
            int characters = 4 - octave;
            middleOctaveNote = middleOctaveNote.toUpperCase();
            for (int i=0; i<characters; i++) {
                sb.append(middleOctaveNote);
            }
        } else if (octave == 4) {
            sb.append(middleOctaveNote);
        } else {
            int characters = 1 + octave - 4;
            for (int i=0; i<characters; i++) {
                sb.append(middleOctaveNote);
            }
        }

        sb.append(skmAlteration.getSkmEncoding());
        return sb.toString();
    }
}
