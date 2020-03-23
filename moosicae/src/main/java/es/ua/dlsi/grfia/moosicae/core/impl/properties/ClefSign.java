package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IClefSign;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class ClefSign extends EnumCoreProperty<EClefSigns> implements IClefSign {
    public ClefSign(@NotNull IId id, @NotNull EClefSigns enumValue) {
        super(id, enumValue);
    }

    @Override
    public ClefSign clone() {
        return new ClefSign(IdGenerator.getInstance().generateUniqueId(), value);
    }

}
