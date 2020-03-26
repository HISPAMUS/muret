package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.ENotationTypes;
import es.ua.dlsi.grfia.moosicae.core.properties.INotationType;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class INotationTypeBuilder extends CoreObjectBuilder<INotationType> {
    private ENotationTypes value;

    public INotationTypeBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public INotationTypeBuilder from(ENotationTypes value) {
        this.value = value;
        return this;
    }

    @Override
    public INotationType build() throws IMException {
        return coreObjectFactory.createNotationType(getId(), value);
    }


}
