package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IDots;
import es.ua.dlsi.grfia.moosicae.core.properties.IFigure;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitch;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import javax.validation.constraints.NotNull;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Note extends DurationalSingle implements INote {
    @NotNull
    private final IPitch pitch;

    Note(@NotNull IId id, @NotNull IFigure figure,  IDots dots, @NotNull IPitch pitch) {
        super(id, figure, dots);
        this.pitch = pitch;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportNote(this, inputOutput);
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
