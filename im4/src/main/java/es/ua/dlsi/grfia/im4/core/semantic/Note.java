package es.ua.dlsi.grfia.im4.core.semantic;

public class Note extends DurationalSemanticItem {
    final NotePitch notePitch;
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

    private LigatureType ligature;

    public Note(Figures figure, int dots, NotePitch notePitch) {
        super(figure, dots);
        this.notePitch = notePitch;
    }

    public StemDirection getStemDirection() {
        return stemDirection;
    }

    public void setStemDirection(StemDirection stemDirection) {
        this.stemDirection = stemDirection;
    }

    public Perfection getPerfection() {
        return perfection;
    }

    public void setPerfection(Perfection perfection) {
        this.perfection = perfection;
    }

    public Coloration getColoration() {
        return coloration;
    }

    public void setColoration(Coloration coloration) {
        this.coloration = coloration;
    }

    public NotePitch getNotePitch() {
        return notePitch;
    }

    public LigatureType getLigature() {
        return ligature;
    }

    public void setLigature(LigatureType ligature) {
        this.ligature = ligature;
    }
}
