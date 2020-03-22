package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Note extends DurationalSingle implements INote {
    @NotNull
    private final IPitch pitch;

    Note(@NotNull IId id, @NotNull IFigure figure, @Nullable IDots dots, @NotNull IPitch pitch) {
        super(id, figure, dots);
        this.pitch = pitch;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public DurationalSingle clone() {
        return new Note(IdGenerator.getInstance().generateUniqueId(), figure, dots, pitch);
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
