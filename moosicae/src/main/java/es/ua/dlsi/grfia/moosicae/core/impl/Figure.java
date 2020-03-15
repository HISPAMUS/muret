package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IFigure;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.utils.Time;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class Figure extends EnumBased<EFigures> implements IFigure {
    public Figure(EFigures enumValue) {
        super(enumValue);
    }

    @Override
    public Figure clone() {
        return new Figure(enumValue);
    }

    @Override
    public EFigures getFigure() {
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
