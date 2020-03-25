package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EBarlineTypes;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class BarlineType extends EnumCoreProperty<EBarlineTypes> implements IBarlineType {
    public BarlineType(IId id, @NotNull EBarlineTypes enumValue) {
        super(id, enumValue);
    }

    @Override
    public BarlineType clone() {
        return new BarlineType(null, value);
    }

}
