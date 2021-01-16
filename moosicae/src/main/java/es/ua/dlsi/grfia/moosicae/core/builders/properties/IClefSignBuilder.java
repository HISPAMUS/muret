package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefSign;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IClefSignBuilder extends CoreObjectBuilder<IClefSign> {
    private EClefSigns value;

    public IClefSignBuilder() {}

    public IClefSignBuilder from(EClefSigns value) {
        this.value = value;
        return this;
    }


    @Override
    public IClefSign build() throws IMException {
        return ICoreAbstractFactory.getInstance().createClefSign(getId(), value);
    }


}
