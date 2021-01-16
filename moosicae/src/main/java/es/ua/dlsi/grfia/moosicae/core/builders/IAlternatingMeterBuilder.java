package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IAlternatingMeter;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeter;

import java.util.LinkedList;
import java.util.List;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IAlternatingMeterBuilder extends CoreObjectBuilder<IAlternatingMeter> {
    private List<IMeter> meters;

    public IAlternatingMeterBuilder() {
        meters = new LinkedList<>();
    }

    public IAlternatingMeterBuilder add(IMeter meter) {
        this.meters.add(meter);
        return this;
    }



    @Override
    public IAlternatingMeter build() throws IMException {
        return ICoreAbstractFactory.getInstance().createAlternatingMeter(getId(), meters.toArray(new IMeter[0]));
    }

}
