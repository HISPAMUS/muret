package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Note extends DurationalSingle implements INote {
    private final IPitch pitch;

    Note(IFigure figure, Optional<IDots> dots, IPitch pitch) {
        super(figure, dots);
        this.pitch = pitch;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public DurationalSingle clone() {
        return new Note(figure, dots, pitch);
    }

    @Override
    public IPitch getPitch() {
        return pitch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        if (!super.equals(o)) return false;

        Note note = (Note) o;

        return pitch.equals(note.pitch);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + pitch.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "pitch=" + pitch +
                "} " + super.toString();
    }
}
