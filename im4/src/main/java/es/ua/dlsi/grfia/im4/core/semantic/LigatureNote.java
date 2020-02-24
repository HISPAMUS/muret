package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;

public abstract class LigatureNote extends Note {
    public LigatureNote(Figures figure, int dots, Perfection perfection, Fermata fermata, Size size, NotePitch notePitch, StemDirection stemDirection, Coloration coloration) throws IM4Exception {
        super(figure, dots, perfection, fermata, size, notePitch, stemDirection, coloration);
    }
}
