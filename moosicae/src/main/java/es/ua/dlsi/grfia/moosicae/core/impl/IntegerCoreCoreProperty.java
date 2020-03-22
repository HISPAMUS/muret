package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.IIntegerCoreProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public abstract class IntegerCoreCoreProperty extends CoreProperty implements IIntegerCoreProperty {
    @NotNull
    protected final Integer value;

    public IntegerCoreCoreProperty(@NotNull IId id, @NotNull Integer value) {
        super(id);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
