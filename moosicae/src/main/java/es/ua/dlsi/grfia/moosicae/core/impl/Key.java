package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IMode;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Key extends CoreItem implements IKey {
    @NotNull
    private final IPitchClass pitchClass;
    @NotNull
    private final IMode mode;
    @NotNull
    private final IKeySignature keySignature;

    Key(IId id, @NotNull IPitchClass pitchClass, @NotNull IMode mode, @NotNull IKeySignature keySignature) {
        super(id);
        this.pitchClass = pitchClass;
        this.mode = mode;
        this.keySignature = keySignature;
    }

    @Override
    public Key clone() {
        return new Key(null, pitchClass, mode, keySignature);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportKey(this, inputOutput);
    }

    @Override
    public IPitchClass getPitchClass() {
        return pitchClass;
    }

    @Override
    public IKeySignature getKeySignature() {
        return keySignature;
    }

    @Override
    public IMode getMode() {
        return mode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;

        Key key = (Key) o;

        if (!pitchClass.equals(key.pitchClass)) return false;
        if (!mode.equals(key.mode)) return false;
        return keySignature.equals(key.keySignature);
    }

    @Override
    public int hashCode() {
        int result = pitchClass.hashCode();
        result = 31 * result + mode.hashCode();
        result = 31 * result + keySignature.hashCode();
        return result;
    }
}
