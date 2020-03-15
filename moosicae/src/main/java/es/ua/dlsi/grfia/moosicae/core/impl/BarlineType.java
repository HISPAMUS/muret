package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.enums.EBarlineTypes;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class BarlineType extends EnumBased<EBarlineTypes> implements IBarlineType {
    public BarlineType(EBarlineTypes enumValue) {
        super(enumValue);
    }

    @Override
    public BarlineType clone() {
        return new BarlineType(enumValue);
    }

    @Override
    public EBarlineTypes getBarlineType() {
        return enumValue;
    }
}
