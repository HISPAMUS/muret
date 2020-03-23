package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IDots;
import es.ua.dlsi.grfia.moosicae.core.properties.IFigure;

import java.util.Optional;

/**
 * Leaf of the composite pattern with IDurationalComposite
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IDurationalSingle extends IDurational {
    IFigure getFigure();
    Optional<IDots> getDots();
}
