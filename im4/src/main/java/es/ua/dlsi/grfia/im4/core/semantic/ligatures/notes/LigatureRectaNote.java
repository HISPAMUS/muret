package es.ua.dlsi.grfia.im4.core.semantic.ligatures.notes;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;
import es.ua.dlsi.grfia.im4.core.semantic.*;

public class LigatureRectaNote extends Note {

    public LigatureRectaNote(Figures figure, int dots, Perfection perfection, Fermata fermata, Size size, NotePitch notePitch, StemDirection stemDirection, Coloration coloration) throws IM4Exception {
        super(figure, dots, perfection, fermata, size, notePitch, stemDirection, coloration);
        setSkmEncodingJustInConstructor(buildSkmEncoding());
    }

    @Override
    public LigatureRectaNote clone() {
        try {
            return new LigatureRectaNote(figure, dots, perfection, fermata, size, notePitch, stemDirection, coloration);
        } catch (IM4Exception e) {
            throw new IM4RuntimeException("Cannot clone LigatureRectaNote", e);
        }
    }
    @Override
    protected String buildSkmEncoding() throws IM4Exception {
        super.buildSkmEncoding();
        throw new UnsupportedOperationException();
    }
}
