package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.LinkedList;
import java.util.List;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IMixedMeterBuilder extends CoreObjectBuilder<IMixedMeter> {
    private List<IMeter> meters;

    public IMixedMeterBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
        meters = new LinkedList<>();
    }

    public IMixedMeterBuilder add(IMeter meter) {
        this.meters.add(meter);
        return this;
    }



    @Override
    public IMixedMeter build() throws IMException {
        return coreObjectFactory.createMixedMeter(getId(), meters.toArray(new IMeter[0]));
    }

}
