package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IMode;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class TheoreticalKey extends Key implements ITheoreticalKey {
    TheoreticalKey(IId id, @NotNull IPitchClass pitchClass, @NotNull IMode mode, IKeySignature keySignature) {
        super(id, pitchClass, mode, keySignature);
    }

    @Override
    public TheoreticalKey clone() {
        return new TheoreticalKey(null, getPitchClass(), getMode(), getKeySignature().isPresent()?getKeySignature().get():null);
    }

    @Override
    public String toString() {
        return "TheoreticalKey{} " + super.toString();
    }
}
