package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.ITimeSignatureNumrerator;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class TimeSignatureNumerator extends IntegerCoreCoreProperty implements ITimeSignatureNumrerator {


    public TimeSignatureNumerator(@NotNull IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public TimeSignatureNumerator clone() {
        return new TimeSignatureNumerator(id, value);
    }
}
