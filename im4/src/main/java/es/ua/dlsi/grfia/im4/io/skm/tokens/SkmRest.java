package es.ua.dlsi.grfia.im4.io.skm.tokens;

import es.ua.dlsi.grfia.im4.io.skm.SkmToken;
import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmDots;
import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmFigure;
import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmPerfection;
import es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens.SkmFermata;

public class SkmRest extends SkmToken {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "r";
    private final SkmFigure skmFigure;
    private final SkmDots skmDots;
    private final SkmPerfection skmPerfection;
    private final Integer linePosition;
    private final SkmFermata skmFermata;

    public SkmRest(SkmFigure skmFigure, SkmDots skmDots, SkmPerfection skmPerfection, Integer linePosition, SkmFermata skmFermata) {
        super(buildSkmEncoding(skmFigure, skmDots, skmPerfection));
        this.skmFigure = skmFigure;
        this.skmDots = skmDots;
        this.skmPerfection = skmPerfection;
        this.linePosition = linePosition;
        this.skmFermata = skmFermata;
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

    public Integer getLinePosition() {
        return linePosition;
    }

    public SkmFermata getSkmFermata() {
        return skmFermata;
    }

    @Override
    public SkmRest clone() {
        return new SkmRest(skmFigure, skmDots, skmPerfection, linePosition, skmFermata);
    }

    private static String buildSkmEncoding(SkmFigure skmFigure, SkmDots skmDots, SkmPerfection skmPerfection) {
        StringBuilder stringBuilder = new StringBuilder(skmFigure.getSkmEncoding());

        if (skmPerfection != null) {
            stringBuilder.append(skmPerfection.getSkmEncoding());
        }

        if (skmDots != null) {
            stringBuilder.append(skmDots.getSkmEncoding());
        }

        return stringBuilder.toString();
    }


}
