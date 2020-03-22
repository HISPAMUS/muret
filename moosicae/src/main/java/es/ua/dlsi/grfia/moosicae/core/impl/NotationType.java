package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.INotationType;
import es.ua.dlsi.grfia.moosicae.core.enums.ENotationTypes;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class NotationType extends EnumBased<ENotationTypes> implements INotationType {
    public NotationType(@NotNull IId id, ENotationTypes enumValue) {
        super(id, enumValue);
    }

    @Override
    public NotationType clone() {
        return new NotationType(IdGenerator.getInstance().generateUniqueId(), enumValue);
    }

    @Override
    public ENotationTypes getValue() {
        return enumValue;
    }
}
