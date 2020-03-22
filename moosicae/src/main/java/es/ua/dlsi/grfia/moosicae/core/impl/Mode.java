package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.IMode;
import es.ua.dlsi.grfia.moosicae.core.enums.EModes;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class Mode extends EnumBased<EModes> implements IMode {
    Mode(@NotNull IId id, @NotNull EModes enumValue) {
        super(id, enumValue);
    }

    @Override
    public Mode clone() {
        return new Mode(IdGenerator.getInstance().generateUniqueId(), enumValue);
    }

    @Override
    public EModes getMode() {
        return enumValue;
    }
}
