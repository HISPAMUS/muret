package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IInterchangingMeter;
import es.ua.dlsi.grfia.moosicae.core.IMeter;

import java.util.LinkedList;
import java.util.List;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IInterchangingMeterBuilder extends CoreObjectBuilder<IInterchangingMeter> {
    private List<IMeter> meters;

    public IInterchangingMeterBuilder() {
        meters = new LinkedList<>();
    }

    public IInterchangingMeterBuilder add(IMeter meter) {
        this.meters.add(meter);
        return this;
    }



    @Override
    public IInterchangingMeter build() throws IMException {
        if (meters.size() != 2) {
            throw new IMException("Cannot build an interchanging meter with " + meters.size() + " meters");
        }
        return ICoreAbstractFactory.getInstance().createInterchangingMeter(getId(), meters.get(0), meters.get(1));
    }

}
