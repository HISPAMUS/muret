package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.enums.mensural.EMensurations;
import es.ua.dlsi.grfia.moosicae.core.mensural.IMensuration;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IMensurationBuilder extends CoreObjectBuilder<IMensuration>  {
    private EMensurations mensurations;

    public IMensurationBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setMensurations(EMensurations mensurations) {
        this.mensurations = mensurations;
    }

    @Override
    public IMensuration build() throws IMException {
        assertRequired("mensurations", mensurations);
        return coreObjectFactory.createMensuration(mensurations);
    }
}
