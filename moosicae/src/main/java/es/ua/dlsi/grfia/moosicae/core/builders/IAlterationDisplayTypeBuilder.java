package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IAlterationDisplayType;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.enums.EAlterationDisplayTypes;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IAlterationDisplayTypeBuilder extends CoreObjectBuilder<IAlterationDisplayType>  {
    private EAlterationDisplayTypes alterationDisplayType;

    public IAlterationDisplayTypeBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setAlterationDisplayType(EAlterationDisplayTypes accidentalSymbols) {
        this.alterationDisplayType = accidentalSymbols;
    }

    @Override
    public IAlterationDisplayType build() throws IMException {
        assertRequired("alterationDisplayType", alterationDisplayType);
        return coreObjectFactory.createAlterationDisplayType(getId(), alterationDisplayType);
    }
}
