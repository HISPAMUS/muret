package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IClefSign;
import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class ClefSign extends EnumCoreProperty<EClefSigns> implements IClefSign {
    ClefSign(@NotNull IId id, @NotNull EClefSigns enumValue) {
        super(id, enumValue);
    }

    @Override
    public ClefSign clone() {
        return new ClefSign(IdGenerator.getInstance().generateUniqueId(), enumValue);
    }

    @Override
    public EClefSigns getValue() {
        return enumValue;
    }
}
