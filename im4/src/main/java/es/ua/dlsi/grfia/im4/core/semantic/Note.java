package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;

public class Note extends DurationalSemanticItem {
    protected final NotePitch notePitch;
    /**
     * Optional stem direction
     */
    protected final StemDirection stemDirection;

    /**
     * Optional mensural coloration
     */
    protected final Coloration coloration;

    public Note(Figures figure, int dots, Perfection perfection, Fermata fermata, Size size,
                NotePitch notePitch, StemDirection stemDirection, Coloration coloration) throws IM4Exception {
        super(null, figure, dots, perfection, fermata, size);
        this.notePitch = notePitch;
        this.stemDirection = stemDirection;
        this.coloration = coloration;
        this.setSkmEncodingJustInConstructor(buildSkmEncoding());
    }

    public NotePitch getNotePitch() {
        return notePitch;
    }

    public StemDirection getStemDirection() {
        return stemDirection;
    }

    public Coloration getColoration() {
        return coloration;
    }

    @Override
    public Note clone() {
        try {
            return new Note(figure, dots, perfection, fermata, size, notePitch, stemDirection, coloration);
        } catch (IM4Exception e) {
            throw new IM4RuntimeException("Cannot clone note", e);
        }
    }

    @Override
    protected String buildSkmEncoding() throws IM4Exception {
        StringBuilder stringBuilder = new StringBuilder(super.buildSkmEncoding());
        stringBuilder.append(this.notePitch.buildSkmEncoding());

        if (this.coloration != null) {
            stringBuilder.append('~');
        }
        return stringBuilder.toString();
    }
}
