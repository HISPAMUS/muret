package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.enums.EBarlineTypes;
import es.ua.dlsi.grfia.moosicae.core.properties.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IBarlineTypeBuilder extends IEnumPropertyBuilder<EBarlineTypes, IBarlineType>  {

    public IBarlineTypeBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public IBarlineType build() throws IMException {
        return coreObjectFactory.createBarlineType(getId(), value);
    }

}
