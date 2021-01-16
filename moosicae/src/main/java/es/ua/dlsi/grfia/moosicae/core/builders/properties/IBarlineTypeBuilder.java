package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EBarlineTypes;
import es.ua.dlsi.grfia.moosicae.core.properties.IBarlineType;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IBarlineTypeBuilder extends CoreObjectBuilder<IBarlineType> {
    private EBarlineTypes value;

    public IBarlineTypeBuilder from(EBarlineTypes value) {
        this.value = value;
        return this;
    }

    @Override
    public IBarlineType build() throws IMException {
        return ICoreAbstractFactory.getInstance().createBarlineType(getId(), value);
    }

}
