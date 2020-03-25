package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IAlterationDisplayType;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EAlterationDisplayTypes;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class AlterationDisplayType extends EnumCoreProperty<EAlterationDisplayTypes> implements IAlterationDisplayType {
    public AlterationDisplayType(IId id, @NotNull EAlterationDisplayTypes enumValue) {
        super(id, enumValue);
    }

    @Override
    public AlterationDisplayType clone() {
        return new AlterationDisplayType(null, value);
    }

}
