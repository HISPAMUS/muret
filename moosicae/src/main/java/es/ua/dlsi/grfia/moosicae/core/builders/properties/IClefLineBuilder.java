package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefLine;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class IClefLineBuilder extends IIntegerPropertyBuilder<IClefLine>  {
    public IClefLineBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public IClefLine build() throws IMException {
        return coreObjectFactory.createClefLine(getId(), value);
    }


}
