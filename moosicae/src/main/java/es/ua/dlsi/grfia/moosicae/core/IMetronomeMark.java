package es.ua.dlsi.grfia.moosicae.core;

import java.util.Optional;

/**
 * e.g. dotted quarter = 120
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public interface IMetronomeMark extends IMark {
    IFigure getFigure();
    Optional<IDots> getDots();
    Integer getValue();
}
