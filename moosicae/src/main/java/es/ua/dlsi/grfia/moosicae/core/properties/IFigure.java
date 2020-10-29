package es.ua.dlsi.grfia.moosicae.core.properties;

import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.utils.Time;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public interface IFigure extends IEnumCoreProperty<EFigures> {
    EFigures getValue();
    Time findDurationWithDots(int dots);
    int computeMeterUnit();
}
