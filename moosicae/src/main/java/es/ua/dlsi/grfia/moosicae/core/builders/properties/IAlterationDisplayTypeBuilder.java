package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EAlterationDisplayTypes;
import es.ua.dlsi.grfia.moosicae.core.properties.IAlterationDisplayType;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IAlterationDisplayTypeBuilder extends CoreObjectBuilder<IAlterationDisplayType> {
    private EAlterationDisplayTypes value;

    public IAlterationDisplayTypeBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IAlterationDisplayTypeBuilder from(EAlterationDisplayTypes value) {
        this.value = value;
        return this;
    }

    @Override
    public IAlterationDisplayType build() throws IMException {
        return coreObjectFactory.createAlterationDisplayType(getId(), value);
    }

}