package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class MixedAlterationsKey extends Key implements IMixedAlterationsKey {
    MixedAlterationsKey(@NotNull IId id, @NotNull IPitchClass pitchClass, @NotNull IMode mode, @NotNull IKeySignature keySignature) {
        super(id, pitchClass, mode, keySignature);
    }

    @Override
    public MixedAlterationsKey clone() {
        return new MixedAlterationsKey(IdGenerator.getInstance().generateUniqueId(), getPitchClass(), getMode(), getKeySignature());
    }

    @Override
    public String toString() {
        return "MixedAlterationsKey{} " + super.toString();
    }
}
