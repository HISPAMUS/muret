package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.IMixedMeter;
import es.ua.dlsi.grfia.moosicae.utils.Time;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class MixedMeter implements IMixedMeter {
    private final IMeter[] submeters;

    public MixedMeter(IMeter[] submeters) {
        this.submeters = submeters.clone();
    }

    @Override
    public IMeter[] getSubMeters() {
        return submeters;
    }

    @Override
    public Time getBarDuration() {
        Time sum = Time.TIME_ZERO;
        for (IMeter sm: submeters) {
            sum = sum.add(sm.getBarDuration());
        }
        return sum;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {

    }

    @Override
    public MixedMeter clone() {
        return new MixedMeter(submeters);
    }
}
