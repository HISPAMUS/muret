package es.ua.dlsi.grfia.im4.core.semantic.ligatures.notes;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;
import es.ua.dlsi.grfia.im4.core.semantic.*;

public class LigatureObliquaNote extends Note {

    public LigatureObliquaNote(Figures figure, int dots, Perfection perfection, Fermata fermata, Size size, NotePitch notePitch, StemDirection stemDirection, Coloration coloration) throws IM4Exception {
        super(figure, dots, perfection, fermata, size, notePitch, stemDirection, coloration);
        setSkmEncodingJustInConstructor(buildSkmEncoding());
    }

    @Override
    public LigatureObliquaNote clone() {
        try {
            return new LigatureObliquaNote(figure, dots, perfection, fermata, size, notePitch, stemDirection, coloration);
        } catch (IM4Exception e) {
            throw new IM4RuntimeException("Cannot clone LigatureObliquaNote", e);
        }
    }

    @Override
    protected String buildSkmEncoding() throws IM4Exception {
        super.buildSkmEncoding();
        throw new UnsupportedOperationException();
    }
}
