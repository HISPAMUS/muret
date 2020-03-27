package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import javax.validation.constraints.NotNull;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Note extends DurationalSingle implements INote {
    @NotNull
    private final INoteHead noteHead;

    Note(IId id, @NotNull IFigure figure,  IDots dots, @NotNull INoteHead noteHead) {
        super(id, figure, dots);
        this.noteHead = noteHead;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportNote(this, inputOutput);
    }

    @Override
    public DurationalSingle clone() {
        return new Note(null, figure, dots, noteHead);
    }

    @Override
    public INoteHead getNoteHead() {
        return noteHead;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        if (!super.equals(o)) return false;

        Note note = (Note) o;

        return noteHead.equals(note.noteHead);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + noteHead.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "pitch=" + noteHead +
                "} " + super.toString();
    }
}
