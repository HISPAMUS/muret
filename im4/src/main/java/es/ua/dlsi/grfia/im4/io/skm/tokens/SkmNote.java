package es.ua.dlsi.grfia.im4.io.skm.tokens;

import es.ua.dlsi.grfia.im4.io.skm.SkmToken;
import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.*;

public class SkmNote extends SkmToken {
    private final SkmFigure skmFigure;
    private final SkmDots skmDots;

    private final SkmScientificPitch skmScientificPitch;
    private final SkmPerfection skmPerfection;
    private final SkmColoration smkColoration;

    public SkmNote(SkmFigure skmFigure, SkmDots skmDots, SkmPerfection skmPerfection, SkmColoration skmColoration, SkmScientificPitch skmScientificPitch) {
        super(buildSkmEncoding(skmFigure, skmDots, skmPerfection, skmColoration, skmScientificPitch));
        this.skmFigure = skmFigure;
        this.skmDots = skmDots;
        this.smkColoration = skmColoration;
        this.skmPerfection = skmPerfection;
        this.skmScientificPitch = skmScientificPitch;
    }

    public SkmFigure getSkmFigure() {
        return skmFigure;
    }

    public SkmDots getSkmDots() {
        return skmDots;
    }

    public SkmPerfection getSkmPerfection() {
        return skmPerfection;
    }

    public SkmColoration getSmkColoration() {
        return smkColoration;
    }

    public SkmScientificPitch getSkmScientificPitch() {
        return skmScientificPitch;
    }

    @Override
    public SkmNote clone() {
        return new SkmNote(skmFigure, skmDots, skmPerfection, smkColoration, skmScientificPitch);
    }

    private static String buildSkmEncoding(SkmFigure skmFigure, SkmDots skmDots, SkmPerfection skmPerfection, SkmColoration skmColoration, SkmScientificPitch skmScientificPitch) {
        StringBuilder stringBuilder = new StringBuilder(skmFigure.getSkmEncoding());

        if (skmPerfection != null) {
            stringBuilder.append(skmPerfection.getSkmEncoding());
        }

        if (skmColoration != null) {
            stringBuilder.append(skmColoration.getSkmEncoding());
        }

        if (skmDots != null) {
            stringBuilder.append(skmDots.getSkmEncoding());
        }

        return stringBuilder.toString();
    }
}
