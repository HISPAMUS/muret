package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import javax.validation.constraints.NotNull;


import java.util.Arrays;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Chord extends PitchedDurationalSingle implements IChord {
    @NotNull
    private final INoteHead[] noteHeads;

    Chord(IId id, IFigure figure,  IDots dots, @NotNull INoteHead [] noteHeads, IStem stem, IGraceNoteType graceNoteType) {
        super(id, figure, dots, stem, graceNoteType);
        this.noteHeads = noteHeads.clone();
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportChord(this, inputOutput);
    }

    @Override
    public Chord clone() {
        return new Chord(null, figure, dots, noteHeads, stem, graceNoteType);
    }

    public INoteHead[] getNoteHeads() {
        return noteHeads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chord)) return false;
        if (!super.equals(o)) return false;

        Chord chord = (Chord) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(noteHeads, chord.noteHeads);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(noteHeads);
        return result;
    }

    @Override
    public String toString() {
        return "Chord{" +
                "pitches=" + Arrays.toString(noteHeads) +
                "} " + super.toString();
    }
}
