package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EBarlineTypes;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class BarlineType extends EnumBased<EBarlineTypes> implements IBarlineType {
    BarlineType(@NotNull IId id, @NotNull EBarlineTypes enumValue) {
        super(id, enumValue);
    }

    @Override
    public BarlineType clone() {
        return new BarlineType(IdGenerator.getInstance().generateUniqueId(), enumValue);
    }

    @Override
    public EBarlineTypes getValue() {
        return enumValue;
    }
}
