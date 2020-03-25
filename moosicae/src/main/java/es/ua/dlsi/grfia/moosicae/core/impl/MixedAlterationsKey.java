package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IMode;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class MixedAlterationsKey extends Key implements IMixedAlterationsKey {
    MixedAlterationsKey(IId id, @NotNull IPitchClass pitchClass, @NotNull IMode mode, @NotNull IKeySignature keySignature) {
        super(id, pitchClass, mode, keySignature);
    }

    @Override
    public MixedAlterationsKey clone() {
        return new MixedAlterationsKey(null, getPitchClass(), getMode(), getKeySignature());
    }

    @Override
    public String toString() {
        return "MixedAlterationsKey{} " + super.toString();
    }
}
