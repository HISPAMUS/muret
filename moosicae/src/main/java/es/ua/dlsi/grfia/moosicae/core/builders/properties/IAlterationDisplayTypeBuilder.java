package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.enums.EAlterationDisplayTypes;
import es.ua.dlsi.grfia.moosicae.core.properties.IAlterationDisplayType;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IAlterationDisplayTypeBuilder extends IEnumPropertyBuilder<EAlterationDisplayTypes, IAlterationDisplayType>  {

    public IAlterationDisplayTypeBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public IAlterationDisplayType build() throws IMException {
        return coreObjectFactory.createAlterationDisplayType(getId(), value);
    }

}
