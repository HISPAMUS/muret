package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IFigure;
import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.utils.Time;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class Figure extends EnumCoreProperty<EFigures> implements IFigure {
    Figure(@NotNull IId id, @NotNull EFigures enumValue) {
        super(id, enumValue);
    }

    @Override
    public Figure clone() {
        return new Figure(IdGenerator.getInstance().generateUniqueId(), enumValue);
    }

    @Override
    public EFigures getValue() {
        return enumValue;
    }

    @Override
    public Time getDurationWithDots(int dots) {
        return enumValue.getDurationWithDots(dots);
    }

    @Override
    public int getMeterUnit() {
        return enumValue.getMeterUnit();
    }
}
