package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IDots;
import es.ua.dlsi.grfia.moosicae.core.properties.IFigure;
import es.ua.dlsi.grfia.moosicae.core.properties.IMetronomeMarkValue;

import java.util.Optional;

/**
 * e.g. dotted quarter = 120
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public interface IMetronomeMark extends IMark {
    IFigure getFigure();
    Optional<IDots> getDots();
    IMetronomeMarkValue getValue();
}
