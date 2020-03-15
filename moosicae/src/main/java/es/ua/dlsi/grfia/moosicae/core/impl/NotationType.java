package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.INotationType;
import es.ua.dlsi.grfia.moosicae.core.enums.ENotationTypes;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class NotationType extends EnumBased<ENotationTypes> implements INotationType {
    public NotationType(ENotationTypes enumValue) {
        super(enumValue);
    }

    @Override
    public NotationType clone() {
        return new NotationType(enumValue);
    }

    @Override
    public ENotationTypes getNotationType() {
        return enumValue;
    }
}
