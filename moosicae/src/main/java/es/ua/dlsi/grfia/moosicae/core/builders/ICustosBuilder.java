package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitch;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class ICustosBuilder extends CoreObjectBuilder<ICustos> {
    private IPitch pitch;
    public ICustosBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public ICustosBuilder from(IPitch pitch) {
        this.pitch = pitch;
        return this;
    }

    @Override
    public ICustos build() throws IMException {
        return coreObjectFactory.createCustos(getId(), pitch);
    }


}
