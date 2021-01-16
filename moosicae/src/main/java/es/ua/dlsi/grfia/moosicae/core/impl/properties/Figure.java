package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.adt.ITime;
import es.ua.dlsi.grfia.moosicae.core.properties.IFigure;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.core.impl.adt.Time;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class Figure extends EnumCoreProperty<EFigures> implements IFigure {
    public Figure(IId id, @NotNull EFigures enumValue) {
        super(id, enumValue);
    }

    @Override
    public Figure clone() {
        return new Figure(null, value);
    }

    @Override
    public ITime findDurationWithDots(int dots) {
        return value.getDurationWithDots(dots);
    }

    @Override
    public int computeMeterUnit() {
        return value.getMeterUnit();
    }
}
