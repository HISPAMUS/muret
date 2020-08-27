package es.ua.dlsi.grfia.moosicae.core.properties;

import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.utils.Time;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public interface IFigure extends IEnumCoreProperty<EFigures> {
    EFigures getValue();
    Time getDurationWithDots(int dots); //TODO compute o find... en lugar de get
    int getMeterUnit(); //TODO compute en lugar de get
}
