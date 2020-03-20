package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IKeySignature;
import es.ua.dlsi.grfia.moosicae.core.IPitchClass;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KeySignature implements IKeySignature {
    private final IPitchClass [] pitchClasses;

    /**
     * Created by factories
     * @param pitchClasses
     */
    KeySignature(IPitchClass[] pitchClasses) {
        this.pitchClasses = pitchClasses.clone();
    }

    @Override
    public IVoiced clone() {
        return new KeySignature(pitchClasses);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public IPitchClass[] getPitchClasses() {
        return pitchClasses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeySignature that = (KeySignature) o;
        return Arrays.equals(pitchClasses, that.pitchClasses);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pitchClasses);
    }

    @Override
    public String toString() {
        return "KeySignature{" +
                "pitchClasses=" + Arrays.toString(pitchClasses) +
                '}';
    }
}
