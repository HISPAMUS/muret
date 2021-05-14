package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.impl.properties.IntegerCoreCoreProperty;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.ITimeSignatureDenominator;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class TimeSignatureDenominator extends IntegerCoreCoreProperty implements ITimeSignatureDenominator {


    public TimeSignatureDenominator(IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public TimeSignatureDenominator clone() {
        return new TimeSignatureDenominator(id, value);
    }
}
