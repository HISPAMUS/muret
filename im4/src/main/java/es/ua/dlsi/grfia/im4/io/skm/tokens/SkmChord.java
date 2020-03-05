package es.ua.dlsi.grfia.im4.io.skm.tokens;

import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;
import es.ua.dlsi.grfia.im4.io.skm.SkmToken;
import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmDots;
import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmFigure;
import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmScientificPitch;

public class SkmChord extends SkmToken {
    private final SkmFigure skmFigure;
    private final SkmDots skmDots;

    private final SkmScientificPitch[] skmScientificPitches;

    public SkmChord(SkmFigure skmFigure, SkmDots skmDots, SkmScientificPitch[] skmScientificPitches) {
        super(buildSkmEncoding(skmFigure, skmDots, skmScientificPitches));
        this.skmFigure = skmFigure;
        this.skmDots = skmDots;

        this.skmScientificPitches = skmScientificPitches.clone();
    }


    public int getNumSkmScientificPitches() {
        return skmScientificPitches.length;
    }


    public SkmScientificPitch getSkmScientificPitch(int index) {
        if (index < 0 || index >= skmScientificPitches.length) {
            throw new IM4RuntimeException("Invalid index " + index + " for " + skmScientificPitches.length + " scientific pitches");
        }
        return skmScientificPitches[index];

    }

    @Override
    public SkmChord clone() {
        return new SkmChord(skmFigure, skmDots, skmScientificPitches);
    }

    private static String buildSkmEncoding(SkmFigure skmFigure, SkmDots skmDots, SkmScientificPitch[] skmScientificPitches) {
        StringBuilder stringBuilder = new StringBuilder(skmFigure.getSkmEncoding());

        if (skmDots != null) {
            stringBuilder.append(skmDots.getSkmEncoding());
        }

        boolean first = true;
        for (SkmScientificPitch skmScientificPitch: skmScientificPitches) {
            if (first) {
                first = false;
            } else {
                stringBuilder.append(' ');
            }
            stringBuilder.append(skmScientificPitch.getSkmEncoding());
        }
        return stringBuilder.toString();
    }


}
