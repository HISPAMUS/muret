package es.ua.dlsi.grfia.moosicae.io.skm.grammar.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;

/**
 * Used to contain any of the meters in the grammar
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 06/04/2020
 */
public class SkmMeterBuilder extends CoreObjectBuilder<IMeter> {
    private IMeter meter;

    public SkmMeterBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public SkmMeterBuilder from(IMeter meter) {
        this.meter = meter;
        return this;
    }

    @Override
    public IMeter build() throws IMException {
        return meter;
    }
}
