package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.IMixedMeter;
import es.ua.dlsi.grfia.moosicae.utils.Time;
import javax.validation.constraints.NotNull;

import java.util.Arrays;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class MixedMeter extends Meter implements IMixedMeter {
    @NotNull
    private final IMeter[] submeters;

    MixedMeter(@NotNull IId id, @NotNull IMeter[] submeters) {
        super(id);
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
        return new MixedMeter(IdGenerator.getInstance().generateUniqueId(), submeters);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MixedMeter)) return false;

        MixedMeter that = (MixedMeter) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(submeters, that.submeters);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(submeters);
    }

    @Override
    public String toString() {
        return "MixedMeter{" +
                "submeters=" + Arrays.toString(submeters) +
                "} " + super.toString();
    }
}
