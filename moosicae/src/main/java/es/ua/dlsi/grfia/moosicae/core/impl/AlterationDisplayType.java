package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IAlterationDisplayType;
import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EAlterationDisplayTypes;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class AlterationDisplayType extends EnumCoreProperty<EAlterationDisplayTypes> implements IAlterationDisplayType {
    AlterationDisplayType(@NotNull IId id, @NotNull EAlterationDisplayTypes enumValue) {
        super(id, enumValue);
    }

    @Override
    public AlterationDisplayType clone() {
        return new AlterationDisplayType(IdGenerator.getInstance().generateUniqueId(), enumValue);
    }

    @Override
    public EAlterationDisplayTypes getValue() {
        return enumValue;
    }
}
