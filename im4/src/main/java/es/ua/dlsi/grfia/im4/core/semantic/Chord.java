package es.ua.dlsi.grfia.im4.core.semantic;


import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;

public class Chord extends DurationalSemanticItem {
    final NotePitch[] notePitches;
    /**
     * Optional stem direction
     */
    private StemDirection stemDirection;
    /**
     * Optional mensural perfection
     */
    private Perfection perfection;
    /**
     * Optional mensural coloration
     */
    private Coloration coloration;

    public Chord(Figures figure, int dots, NotePitch[] notePitches, Perfection perfection, Fermata fermata, Size size, Coloration coloration) throws IM4Exception {
        super(null, figure, dots, perfection, fermata, size);
        this.notePitches = notePitches.clone();
        this.coloration = coloration;
        this.setSkmEncodingJustInConstructor(buildSkmEncoding());
    }

    public StemDirection getStemDirection() {
        return stemDirection;
    }

    public void setStemDirection(StemDirection stemDirection) {
        this.stemDirection = stemDirection;
    }

    public NotePitch[] getNotePitches() {
        return notePitches;
    }


    @Override
    public Perfection getPerfection() {
        return perfection;
    }

    @Override
    public Chord clone() {
        try {
            return new Chord(figure, dots, notePitches, perfection, fermata, size, coloration);
        } catch (IM4Exception e) {
            throw new IM4RuntimeException("Cannot clone chord", e);
        }
    }

    @Override
    protected String buildSkmEncoding() throws IM4Exception {
        StringBuilder stringBuilder = new StringBuilder(super.buildSkmEncoding());
        boolean first = true;
        for (NotePitch notePitch: notePitches) {
            if (first) {
                first = false;
            } else {
                stringBuilder.append(' ');
            }
            stringBuilder.append(notePitch.buildSkmEncoding());
        }

        if (this.coloration != null) {
            stringBuilder.append('~');
        }
        return stringBuilder.toString();
    }
}
