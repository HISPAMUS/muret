package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Key implements IKey {
    private final IPitchClass pitchClass;
    private final IMode mode;
    private final IKeySignature keySignature;

    public Key(IPitchClass pitchClass, IMode mode, IKeySignature keySignature) {
        this.pitchClass = pitchClass;
        this.mode = mode;
        this.keySignature = keySignature;
    }

    @Override
    public Key clone() {
        return new Key(pitchClass, mode, keySignature);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
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
}
