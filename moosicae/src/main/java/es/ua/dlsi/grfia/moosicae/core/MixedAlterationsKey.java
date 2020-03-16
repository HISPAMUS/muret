package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.impl.Key;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class MixedAlterationsKey extends Key implements IMixedAlterationsKey {
    public MixedAlterationsKey(IPitchClass pitchClass, IMode mode, IKeySignature keySignature) {
        super(pitchClass, mode, keySignature);
    }

    @Override
    public MixedAlterationsKey clone() {
        return new MixedAlterationsKey(getPitchClass(), getMode(), getKeySignature());
    }

    @Override
    public String toString() {
        return "MixedAlterationsKey{} " + super.toString();
    }
}
