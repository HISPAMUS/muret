package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IAlterationDisplayType;
import es.ua.dlsi.grfia.moosicae.core.enums.EAlterationDisplayTypes;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class AlterationDisplayType extends EnumBased<EAlterationDisplayTypes> implements IAlterationDisplayType {
    public AlterationDisplayType(EAlterationDisplayTypes enumValue) {
        super(enumValue);
    }

    @Override
    public AlterationDisplayType clone() {
        return new AlterationDisplayType(enumValue);
    }

    @Override
    public EAlterationDisplayTypes getAlterationDisplayType() {
        return enumValue;
    }
}
