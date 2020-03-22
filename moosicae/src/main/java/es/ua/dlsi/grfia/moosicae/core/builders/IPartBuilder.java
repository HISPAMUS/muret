package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IName;
import es.ua.dlsi.grfia.moosicae.core.IPart;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IPartBuilder extends CoreObjectBuilder<IPart>  {
    private IName name;

    public IPartBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setName(IName name) {
        this.name = name;
    }

    @Override
    public IPart build() throws IMException {
        return coreObjectFactory.createPart(getId(), name);
    }
}
