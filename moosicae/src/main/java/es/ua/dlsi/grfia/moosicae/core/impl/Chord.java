package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Chord extends DurationalSingle implements IChord {
    private final IPitch[] pitches;

    Chord(EFigures figure, Optional<IDots> dots, IPitch [] pitches) {
        super(figure, dots);
        this.pitches = pitches.clone();
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public Chord clone() {
        return new Chord(figure, dots, pitches);
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
