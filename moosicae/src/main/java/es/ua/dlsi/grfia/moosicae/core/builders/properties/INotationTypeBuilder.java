package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.enums.ENotationTypes;
import es.ua.dlsi.grfia.moosicae.core.properties.INotationType;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class INotationTypeBuilder extends IEnumPropertyBuilder<ENotationTypes, INotationType> {
    public INotationTypeBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public INotationType build() throws IMException {
        return coreObjectFactory.createNotationType(getId(), value);
    }


}