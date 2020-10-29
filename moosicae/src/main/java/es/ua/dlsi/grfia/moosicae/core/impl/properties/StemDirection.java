package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.enums.EStemDirection;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IStemDirection;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class StemDirection extends EnumCoreProperty<EStemDirection> implements IStemDirection {
    public StemDirection(IId id, @NotNull EStemDirection enumValue) {
        super(id, enumValue);
    }

    @Override
    public StemDirection clone() {
        return new StemDirection(null, value);
    }

}
