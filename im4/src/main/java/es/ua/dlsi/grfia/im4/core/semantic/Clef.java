package es.ua.dlsi.grfia.im4.core.semantic;


import java.util.Objects;

public abstract class Clef extends SemanticItem implements INotationTypeDependant {
    protected final NotationType notationType;
    private final PositionInStaff[] flatPositions;
    private final PositionInStaff[] sharpPositions;
    private final DiatonicPitch note;
    /**
     * Bottom line is 1, in a pentagram, top line is 5
     */
    private final int line;

    /**
     * e.g 4 for G2, 3 for F4
     */
    int noteOctave;
    /**
     * 1 for ottava alta, -1 for ottava bassa
     */
    private final int octaveChange;
    /**
     * Staff bottom line (1) diatonic pitch. We save it for avoiding its recomputing each time it is needed
     */
    private final DiatonicPitch bottomLineDiatonicPitch;
    /**
     * Staff bottom line (1) pitch octave. We save it for avoiding its recomputing each time it is needed
     */
    private final int bottomLineOctave;

    public Clef(NotationType notationType, DiatonicPitch note, int line, int noteOctave, PositionInStaff [] sharpPositions, PositionInStaff [] flatPositions
    ) {
        //20180207 this (note, line, noteOctave, sharpKeySignatureStartingOctave, flatKeySignatureStartingOctave, 0);
        this (notationType, note, line, noteOctave, 0, sharpPositions, flatPositions);
    }

    /**
     *
     * @param note Can be null for tab or percussion clefs
     * @param line
     * @param noteOctave
     * @param octaveChange
     * @param sharpPositions For key signatures
     * @param flatPositions For key signatures
     */
    public Clef(NotationType notationType, DiatonicPitch note, int line, int noteOctave,
                int octaveChange, PositionInStaff [] sharpPositions, PositionInStaff [] flatPositions
    ) {
        Objects.requireNonNull(notationType, "notationType");
        Objects.requireNonNull(sharpPositions, "sharpPositions");
        Objects.requireNonNull(flatPositions, "flatPositions");

        this.notationType = notationType;
        this.octaveChange = octaveChange;
        this.note = note;
        this.line = line;
        this.noteOctave = noteOctave; // clef.getOctaveTransposition();
        this.sharpPositions = sharpPositions;
        this.flatPositions = flatPositions;

        // 	private int computeBottomLineNoteOrder(Clef clef) {

        // compute staff bottom line diatonic pitch
        int noteOrder = note == null?0:(note.getOrder() + noteOctave * 7);
        int bottomLineNoteOrder = noteOrder - (line - 1) * 2;
        this.bottomLineDiatonicPitch = DiatonicPitch.values()[bottomLineNoteOrder % 7];
        this.bottomLineOctave = bottomLineNoteOrder / 7;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clef clef = (Clef) o;
        return line == clef.line &&
                noteOctave == clef.noteOctave &&
                octaveChange == clef.octaveChange &&
                notationType == clef.notationType &&
                note == clef.note;
    }

    @Override
    public int hashCode() {
        return Objects.hash(notationType, note, line, noteOctave, octaveChange);
    }

    @Override
    public NotationType getNotationType() {
        return notationType;
    }

    public DiatonicPitch getNote() {
        return note;
    }

    /**
     * Bottom line is 1, in a pentagram, top line is 5
     * @return
     */
    public int getLine() {
        return line;
    }

    public int getNoteOctave() {
        return noteOctave;
    }

    @Override
    public String toString() {
        return "Clef{" + "note=" + note + ", line=" + line + ", noteOctave=" + noteOctave + '}';
    }

    public int getOctaveChange() {
        return octaveChange;
    }

    public abstract Clef clone();

    public DiatonicPitch getBottomLineDiatonicPitch() {
        return bottomLineDiatonicPitch;
    }

    public int getBottomLineOctave() {
        return bottomLineOctave;
    }

    public PositionInStaff[] getFlatPositions() {
        return flatPositions;
    }

    public PositionInStaff[] getSharpPositions() {
        return sharpPositions;
    }

}
