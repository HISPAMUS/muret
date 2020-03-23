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


import java.util.Arrays;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Chord extends DurationalSingle implements IChord {
    @NotNull
    private final IPitch[] pitches;

    Chord(@NotNull IId id, IFigure figure,  IDots dots, @NotNull IPitch [] pitches) {
        super(id, figure, dots);
        this.pitches = pitches.clone();
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportChord(this, inputOutput);
    }

    @Override
    public Chord clone() {
        return new Chord(IdGenerator.getInstance().generateUniqueId(), figure, dots, pitches);
    }

    @Override
    public IPitch[] getPitches() {
        return pitches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chord)) return false;
        if (!super.equals(o)) return false;

        Chord chord = (Chord) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(pitches, chord.pitches);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(pitches);
        return result;
    }

    @Override
    public String toString() {
        return "Chord{" +
                "pitches=" + Arrays.toString(pitches) +
                "} " + super.toString();
    }
}
