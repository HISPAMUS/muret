package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EBarlineTypes;
import es.ua.dlsi.grfia.moosicae.core.properties.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IBarlineTypeBuilder extends CoreObjectBuilder<IBarlineType> {
    private EBarlineTypes value;

    public IBarlineTypeBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IBarlineTypeBuilder from(EBarlineTypes value) {
        this.value = value;
        return this;
    }

    @Override
    public IBarlineType build() throws IMException {
        return coreObjectFactory.createBarlineType(getId(), value);
    }

}
