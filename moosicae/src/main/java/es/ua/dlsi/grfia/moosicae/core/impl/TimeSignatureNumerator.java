package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.impl.properties.IntegerCoreCoreProperty;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.ITimeSignatureNumerator;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class TimeSignatureNumerator extends IntegerCoreCoreProperty implements ITimeSignatureNumerator {


    public TimeSignatureNumerator(@NotNull IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public TimeSignatureNumerator clone() {
        return new TimeSignatureNumerator(id, value);
    }
}
