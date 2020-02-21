package es.ua.dlsi.grfia.im4.core.semantic;


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

    public Chord(Figures figure, int dots, NotePitch[] notePitches) {
        super(figure, dots);
        this.notePitches = notePitches.clone();
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
}
