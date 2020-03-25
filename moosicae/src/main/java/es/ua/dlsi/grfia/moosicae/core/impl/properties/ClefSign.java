package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IClefSign;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class ClefSign extends EnumCoreProperty<EClefSigns> implements IClefSign {
    public ClefSign(IId id, @NotNull EClefSigns enumValue) {
        super(id, enumValue);
    }

    @Override
    public ClefSign clone() {
        return new ClefSign(null, value);
    }

}
