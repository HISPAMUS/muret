package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.adt.ITime;
import es.ua.dlsi.grfia.moosicae.core.adt.ITimeBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.ICompositeMeter;

import javax.validation.constraints.NotNull;

import java.util.Arrays;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public abstract class CompositeMeter extends Meter implements ICompositeMeter {
    @NotNull
    private final IMeter[] submeters;

    CompositeMeter(IId id, @NotNull IMeter[] submeters) {
        super(id);
        this.submeters = submeters.clone();
    }

    @Override
    public IMeter[] getSubMeters() {
        return submeters;
    }

    @Override
    public ITime getBarDuration() {
        ITime sum = ITimeBuilder.getInstance().timeZero();
        for (IMeter sm: submeters) {
            sum = sum.add(sm.getBarDuration());
        }
        return sum;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeMeter)) return false;

        CompositeMeter that = (CompositeMeter) o;

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
