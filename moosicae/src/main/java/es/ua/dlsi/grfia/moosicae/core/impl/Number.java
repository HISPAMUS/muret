package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.INumber;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class Number extends IntegerCoreCoreProperty implements INumber {


    public Number(@NotNull IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public Number clone() {
        return new Number(id, value);
    }
}
